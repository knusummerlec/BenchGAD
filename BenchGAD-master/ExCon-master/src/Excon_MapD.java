/**************************************************
 * Copyright (c) 2019 KNU DEAL Lab. To Present
 * All rights reserved.
 **************************************************/
import manage_data.DataManager;
import manage_data.resultJSON;
import manage_data.userJSON;
import org.apache.commons.math3.analysis.function.Add;
import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class Excon_MapD extends Excon_DBs{

    
    userJSON Mapd_config;
    resultJSON Mapd_result;
    Excon_MapD(String _user, String _passwd)
    {
        user = _user;
        passwd = _passwd; // authorizing 필요
        JDBC_DRIVER = "com.mapd.jdbc.MapDDriver";
        server_address = "Your address";
        port_number = "your port";
        DB_URL = "jdbc:mapd://" + server_address + ":" + port_number + ":" + user;
        DB_connect();
    }
    Excon_MapD(String _user, String _passwd, String address, short _portnum)
    {
        user = _user;
        passwd = _passwd;
        this.setServerAddress(address);
        this.setServerPort(_portnum);
        //passwd authorizing
        JDBC_DRIVER = "com.mapd.jdbc.MapDDriver";
        DB_URL = "jdbc:mapd://" + server_address + ":" + port_number + ":" + user;
        DB_connect();
    }
    Excon_MapD(userJSON _userdefined)
    {
        Mapd_config = _userdefined;
        user = Mapd_config.getUser_id();
        passwd = Mapd_config.getUser_passwd();
        server_address = Mapd_config.getAddress();
        port_number = Mapd_config.getPortnum();
        iterations = Mapd_config.getIteration_num();
        query = Mapd_config.getText();
        //this.setQueryNumber(Mapd_config.getQuery_number());
        JDBC_DRIVER = "com.mapd.jdbc.MapDDriver";
        DB_URL = "jdbc:mapd://" + server_address + ":" + port_number + ":" + user;
        DB_connect();
    }
    public void setQueryNumber(int _query/*, JSON Data*/)
    {
        if(_query <= 0 || _query >= 23)
        {
            System.out.println("Invalid number for query");
            return;
        }
        query_number = _query;
        String file_name = new String("mapd_tpch" + query_number + "th.sql");
        String print_sql = new String("");
        String sent_sql = new String("");
        StringBuffer strbuf = new StringBuffer();
        try
        {
            BufferedReader mapd_convertedQL = new BufferedReader(new FileReader(file_name));
            do {
                print_sql = mapd_convertedQL.readLine();
                //System.out.println(print_sql);
                if(print_sql != null)
                    strbuf.append(print_sql + " ");
            }while(print_sql != null);
            //sent_sql = "select * from NATION";
            query = strbuf.toString();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void setFromJSON(userJSON _userdefined)
    {
        Main.Dave.setDataByJson(_userdefined);
        Mapd_config = Main.Dave.getUser_data();
        Mapd_config = _userdefined;
        user = Mapd_config.getUser_id();
        passwd = Mapd_config.getUser_passwd();
        query = Mapd_config.getText();
        server_address = Mapd_config.getAddress();
        port_number = Mapd_config.getPortnum();
        iterations = Mapd_config.getIteration_num();
        this.setQueryNumber(Mapd_config.getQuery_number());
    }

    public void setServerPort(short _portnum) { port_number = _portnum; }
    public void setServerAddress(String Address){    server_address = Address;   }
    public String getCurrentQuery(){ return query; }
    public int getCurrentNumber(){return query_number;}
    public void SendQueryByString(){send_query(query);} //(line by line, String array?)
    public void SendQueryByString(String _query) //(line by line, String array?)
    {
        //Grammar Correcting
        query = _query;
        send_query(query);
    }
    public void SendQueryByNumber() { send_query(query); } // 한 번만 실행하는 코드임. 여러 번 실행해보고 싶다면, ExecExperiment로 클래스 내부에서 실행 가능하도록 하는 것이 좋을 것 같았음.
    public void SendQueryByNumber(int _number)
    {
        if(_number < 0 || _number >= 23)
        {
            System.out.println("Invalid number for query");
            return;
        }
        this.setQueryNumber(_number);
        this.SendQueryByNumber();
    }

    @Override
    protected void DB_connect()
    {
        //Register JDBC Driver;
        try
        {
            Class.forName(JDBC_DRIVER);
            //Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
            // Open connection
            conn = DriverManager.getConnection(DB_URL, user, passwd);
            stmt = conn.createStatement();
        }
        catch(ClassNotFoundException e) { e.printStackTrace(); }
        catch(SQLException e) {e.printStackTrace();}
        
    }
    @Override
    protected ArrayList <Long> ExecExperiment()
    {
        ArrayList <Long> result = new ArrayList<>();
        for(int i = 0; i<iterations; i++)
        { result.add(send_query(query)); }
        return result;
    }
    @Override
    protected Long send_query(String _query)
    {
        // ;는 sql 안에 포함해서는 안된다. unknown parse 라며 에러를 띄운다. --> 자체적인 parsing이 필요할 것이다.
        // \gpu를 JDBC 상에서 실행시킬 수 없다. Parse failed: "\\" encountered. 에러가 뜰 것이다.
        long JDBC_time = 0L;
        try {
            long timer = System.currentTimeMillis();
            stmt.execute(_query);
            JDBC_time = System.currentTimeMillis() - timer;
            System.out.println("JDBC Time: " + JDBC_time);
            return JDBC_time;
        }
        catch(SQLException e) { e.printStackTrace(); }
        finally { return JDBC_time; }
    }
}
