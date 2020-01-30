package Data;

import java.io.Serializable;

public class Alldata implements Serializable{

    //all data parameter getter and setter
    private String project_name;
    private String bench_type;
    private int scale_factor;
    private int transaction_refresh_rate;
    private boolean GPU_use=false;
    private int CPU_count;
    private String text;
    private String dblist[];
    private int dbnum;
    
    public Alldata() {
       ;
    }
    
    public void setProject_name(String name) {
        this.project_name = name;
    }
    
    public void setBench_type(String type) {
        this.bench_type = type;
    }

    public void setScale_factor(int scale_factor) {
        this.scale_factor = scale_factor;
    }

    public void setTransaction_refresh_rate(int transaction_refresh_rate) {
        this.transaction_refresh_rate = transaction_refresh_rate;
    }

    public void setGPU_use(boolean GPU_use) {
        this.GPU_use = GPU_use;
    }

    public void setCPU_count(int CPU_count) {
        this.CPU_count = CPU_count;
    }
    
    public void settext(String text){
        this.text=text;
    }

    public void setDblist(String[] dblist,int size) {
        this.dbnum=size;
        this.dblist=new String[size];
        for(int i=0;i<size;i++) {
            this.dblist[i]=dblist[i];
            System.out.println(this.dblist[i]);
        }
       
    }
    
    public String getProject_name() {
        return project_name;
    }
    
    public String getBench_type() {
        return bench_type;
    }

    public int getScale_factor() {
        return scale_factor;
    }

    public int getTransaction_refresh_rate() {
        return transaction_refresh_rate;
    }

    public boolean isGPU_use() {
        return GPU_use;
    }

    public int getCPU_count() {
        return CPU_count;
    }

    public String getText() {
        return text;
    }

    public String[] getDblist() {
        return dblist;
    }

    public int getDbnum() {
        return dbnum;
    }
}