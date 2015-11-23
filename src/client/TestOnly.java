package client;
import entity.printWriter;
import entity.ReadFile;
import java.io.*;


public class TestOnly {


    public static void main(String[] args) {
        String file_name = "D:\\Jaylim\\Desktop\\test.txt" ; 
        int testNumber = 101;
        
        
        /*Read from File
        try {
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile();
            int i;
            
            for (i=0; i<aryLines.length; i++){
                System.out.println(aryLines[i]);
            }
            
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        */
        
        // Write into file
        try{
            printWriter data = new printWriter(file_name, true);
            
            for (int a = 0; a<50; a++){
                data.writeToFile("This is new line yoh " + testNumber++ + "\n" );
            }
            
            System.out.println("Text File Done");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
       
        
    }
    
}
