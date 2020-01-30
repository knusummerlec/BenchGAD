package manage_data;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataManager {
    static userJSON user_data;
    static resultJSON result_data;
    ObjectMapper JsonManager;
    public DataManager()
    {
        user_data = new userJSON();
        result_data = new resultJSON();
        user_data.DB_name = "MapD";
        user_data.workload = "TPCH";
        user_data.iteration_num = 10;
        user_data.query_number = 1;
        user_data.scale_factor = 1;
        user_data.address = "155.230.34.143";
        user_data.portnum = 9091;
        user_data.user_id = "mapd";
        user_data.user_passwd = "HyperInteractive";
    }
    public DataManager(userJSON _userdefined)
    {
        result_data = new resultJSON();
        user_data = _userdefined;
    }
    public void setUser_data(userJSON _userdefined){user_data = _userdefined;}
    public userJSON getUser_data(){ return user_data; }
    public resultJSON getResult_data() { return result_data; }
    public userJSON getDataFromFile(String _fname)
    {
        try
        {
            user_data = JsonManager.readValue(new File(_fname), userJSON.class);
        }
        catch(IOException e) {  e.printStackTrace(); }
        return user_data;
    }

    public void setDB(String _name){ user_data.DB_name = _name; }

    public void setResult_data(ArrayList<Long> _result) {
        StringBuffer res_buf = new StringBuffer();
        for(int i = 0; i < _result.size(); i++)
            res_buf.append(_result.get(i) + " ");
        result_data.project_name = user_data.project_name;
        result_data.exp_result = res_buf.toString();
    }

    public userJSON setDataByJson(userJSON _userdefined)
    {
        return user_data;
    }
}
