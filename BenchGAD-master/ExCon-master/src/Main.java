/**************************************************
 * Copyright (c) 2019 KNU DEAL Lab. To Present
 * All rights reserved.
 **************************************************/
import com.esri.core.geometry.JsonParserReader;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import manage_data.DataManager;
import manage_data.resultJSON;
import manage_data.userJSON;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import java.beans.Visibility;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static DataManager Dave = new DataManager();

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        REST mongo_server = new REST();

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        while(true)
        {
            ArrayList<String> line = new ArrayList<>();
            String[] query_list = {""};
            String[] toquery ={""};
            while(toquery[0].equals("[]") || line.isEmpty()) {
                try
                {
                    Thread.sleep(100);
                    line = mongo_server.getInfo();
                    for(int i = 0; i<line.size(); i++)
                    {
                        toquery[i] = line.get(i);
                    }
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
            toquery[0] = line.get(0);
            toquery[0] = toquery[0].substring(1, toquery[0].length() - 1);
            query_list = toquery[0].split("},");
            query_list[0] = query_list[0].concat("}");
            try
            {
                System.out.println(query_list[0]);
                userJSON jk = mapper.readValue(toquery[0], userJSON.class);
                Dave.setUser_data(jk);
                Excon_MapD my_mapd = new Excon_MapD(jk);
                System.out.println("Scale factor: " +  jk.getScale_factor());
                ArrayList<Long> expResult;
                expResult = my_mapd.ExecExperiment();
                System.out.println(expResult);
                Dave.setResult_data(expResult);
                resultJSON to_post = Dave.getResult_data();
                mongo_server.postInfo(to_post);

            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        //Server Input
        //Send query
        //Serve Output
    }
}
