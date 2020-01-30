package manage_data;

public class userJSON {
    String project_name;
    String DB_name;
    String dblist[];
    int dbnum;
    int scale_factor;
    boolean gpu_use = true;
    int transaction_refresh_rate = 20;
    String text;
    String workload;
    int iteration_num = 10;
    int query_number;
    String address = "155.230.34.143";
    short portnum = 9091;
    String user_id = "mapd"; //db_id
    String user_passwd = "HyperInteractive"; // db_password


    //test
    String _id;
    int cpu_count;
    int status;
    int __v; // junk
    public int getIteration_num() { return iteration_num; }

    public int getQuery_number() {
        return query_number;
    }

    public int getScale_factor() {
        return scale_factor;
    }

    public short getPortnum() {
        return portnum;
    }

    public String getAddress() {
        return address;
    }

    public String getDB_name() {
        return DB_name;
    }
    public String getUser_id() {
        return user_id;
    }

    public String getUser_passwd() {
        return user_passwd;
    }
    public String getText(){return text;}
    public String getWorkload() {
        return workload;
    }
}


