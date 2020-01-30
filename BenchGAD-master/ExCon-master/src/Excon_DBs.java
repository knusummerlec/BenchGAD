/**************************************************
 * Copyright (c) 2019 KNU DEAL Lab. To Present
 * All rights reserved.
 **************************************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

abstract public class Excon_DBs {
    /*Needed parameters*/
    int scale_factor;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String TPC_type;
    String query;
    String user;
    String passwd;
    String server_address;
    short port_number;
    //int authorized;
    String JDBC_DRIVER;
    static String DB_URL;
    String DB_name;
    int query_number;
    int grammar_type;
    Object query_param;
    int iterations;

    /*methods*/
    protected abstract void DB_connect();
    //protected abstract void send_query(int _query_numbers);
    protected abstract Long send_query(String _query);
    protected abstract ArrayList <?> ExecExperiment();
}
