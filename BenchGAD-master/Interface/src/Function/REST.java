package Function;

import Data.Alldata;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.io.DataOutputStream;
import javax.net.ssl.HttpsURLConnection;
/*
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;*/
import org.codehaus.jackson.JsonGenerationException; 
import org.codehaus.jackson.JsonParseException; 
import org.codehaus.jackson.map.JsonMappingException; 
import org.codehaus.jackson.map.ObjectMapper;

public class REST {
    String SURL = "http://155.230.34.150:3000/users";
    public void getInfo()
    {
        BufferedReader in = null;
        for(int i=1;i<=1;i++)
        {
            try {
                //URL obj = new URL("http://127.0.0.1:3000/users/"+i); // 호출할 url
                URL obj=new URL(SURL + "/" + i);
                HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                 con.setRequestProperty("Accept", "application/json");
                con.setRequestMethod("GET");
 
                in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        
                String line;
                while((line = in.readLine()) != null) { // response를 차례대로 출력
                    System.out.println(line);
           
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); }
            }
        }
    }
    public void postInfo(Alldata topost)
    {
     
         try {

		URL url = new URL(SURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
                int id=1;
                String name="pew";
                String test="{\"id\":"+id+",\"name\":\""+name+"\"}"; //숫자 구분됨
                System.out.println(test);
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

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }
        
        
        
        
    }
    
    
    
}
