package Function;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    
    public CSVExporter(String filePath, String title, List<String> list) {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(filePath + "/" + title + ".csv", true));
            
            for (String dom : list) {
                fw.write(dom + "," + "test");
                fw.newLine();
            }
            
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
