/**************************************************
 * Copyright (c) 2019 KNU DEAL Lab. To Present
 * All rights reserved.
 **************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
/*
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;*/
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import manage_data.resultJSON;
import manage_data.userJSON;
import com.fasterxml.jackson.databind.ObjectMapper;




/**
 *
 * @author knuprime097
 */
public class REST {
    public ArrayList<String> getInfo()
    {
        BufferedReader in = null;
        ArrayList<String> buffer_line = new ArrayList<>();
        for(int i=1;i<=1;i++)
        {
            try {
                //URL obj = new URL("http://127.0.0.1:3000/users/"+i); // 호출할 url
                URL obj=new URL("http://155.230.34.150:3000/users/200/ch");
                HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                 con.setRequestProperty("Accept", "application/json");
                con.setRequestMethod("GET");//Server->mapd
 
                in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                int j = 0;
                String line;
                while((line = in.readLine()) != null) { // response를 차례대로 출력

                    buffer_line.add(line);
                }

            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                if(in != null) try { in.close(); return buffer_line;} catch(Exception e) { e.printStackTrace(); }
            }
        }
        return null;
    }
    public void postInfo(resultJSON topost)
    {
     
         try {

		URL url = new URL("http://155.230.34.150:3000/users/result");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		//mapd->server
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
                int id=1;
                //{"_id":"5b7d00bdd8cf6a4dfc0d0edc","id":18,"name":"pew18","__v":0}
                // Send typd String or Number
		//String input = "{\"transacation_refresh_rate\":"+topost.getTransaction_refresh_rate()+",\"GPU_use\":"+topost.isGPU_use()+",\"CPU_count\":"+topost.getCPU_count()+",\"text\":"+topost.getText()+",\"dbnum\":"+topost.getDbnum()+",\"dblist\":"+topost.getDblist()+"}";
                //String input = "{\"transacation_refresh_rate\":"+topost.getTransaction_refresh_rate()+",\"GPU_use\":"+topost.isGPU_use()+",\"CPU_count\":"+topost.getCPU_count()+",\"text\":"+topost.getText()+",\"dbnum\":"+topost.getDbnum()+"}";

                ObjectMapper mapper = new ObjectMapper();

                // result.json 파일로 저장
                //mapper.writeValue(new File("result.json"), myResultObject);
                // byte[] 로 저장
                //byte[] jsonBytes = mapper.writeValueAsBytes(myResultObject);
                // string 으로 저장
                //String input = mapper.writeValueAsString(topost);
                //jackson lib 사용시 대문자 변수명>소문자로 변환 주의
             mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                String input = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(topost);

                System.out.println(input);
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());

		os.flush();
		os.close();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}
		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }
        
        
        
        
    }
    
    
    
}
