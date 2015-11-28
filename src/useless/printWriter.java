package useless;


import java.io.*;

/**
 *
 * @author Jaylim
 */
public class printWriter {
    
    private String path;
    private boolean append = false;
    
    public printWriter(String file_path, boolean append_value){
        path = file_path;
        append = append_value;
    }
    
    public printWriter(String file_path){
        path = file_path;
    }
    
    public void writeToFile(String textLine) throws IOException {
        FileWriter write = new FileWriter( path , append);
        PrintWriter print_line = new PrintWriter(write);
        
        print_line.printf("%s" + "%n", textLine);
        print_line.close();
        
    }

}
