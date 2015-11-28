
package useless;

import java.io.*;

/**
 *
 * @author Jaylim
 */
public class ReadFile {
    private String path;
    
    public ReadFile(String file_path){
        path = file_path;
    }
    
    public String[] OpenFile() throws IOException{
        FileReader fileReader = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fileReader);
        
        int noOfLines = readLines();
        String []  textData = new String [noOfLines];
        
        for (int i=0; i< noOfLines ; i++){
            textData[i] = textReader.readLine();
        }
        
        textReader.close();
        return textData;
    }
    
    int readLines() throws IOException{
        FileReader file_to_read = new FileReader(path);
        BufferedReader buffReader = new BufferedReader(file_to_read);
        
        String lines;
        int numberOfLines = 0;
        
        while((lines = buffReader.readLine()) != null){
            numberOfLines++;
        }
        
        buffReader.close();
        return numberOfLines;
    }
}
