// author zf
import java.util.*;

public class Driver {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String selection;
        
        System.out.println("\n");
    		System.out.println("1. Register and Start the game");
	    	System.out.println("2. View Ranking");
	    	System.out.println("3. Exit");
	    	System.out.print("Selection: ");
                selection = scan.next();
                
                if(selection.equals("1")){
	    		registerMember();
                        gameStart();
	    	}else if(selection.equals("2")){
	    		viewRanking();
	    	}else if(selection.equals("3")){
	    		System.exit(-1);
	    	}else{
	    		System.out.println("Error. Please enter again.");
	    		System.out.println();
                }
    }

    private static void registerMember() {
        String name;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n-Registration-\nPlayer Name:");
        name = scan.nextLine();
        
    }

    private static void gameStart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void viewRanking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
