
package client;


import adt.PlayerList;
import adt.PlayerListInterface;
import adt.StationList;
import controller.*;
import entity.Player;
import java.util.*;
import adt.StationListInterface;
import entity.Station;

/**
 *
 * @author Jaylim
 */
public class RaceDriver {
    
    StationListInterface<Station> stationList = new StationList<>();
    PlayerListInterface<Player> listPlayer = new PlayerList<>();
    Player player = new Player();
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) { 

       gameStart gameStart = new gameStart();
       setStation setStation = new setStation();

       String selection;
        
        System.out.println("\n");
    		System.out.println("1. Start the game");
	    	System.out.println("2. View Ranking");
	    	System.out.println("3. Exit");
	    	System.out.print("Selection: ");
                selection = scan.next();
                
                if(selection.equals("1")){
                    setStation.setStation();
                    long timeEnd = gameStart.run();
                    registerMember(timeEnd);
                    
	    	}else if(selection.equals("2")){
	    		viewRanking();
	    	}else if(selection.equals("3")){
	    		System.exit(-1);
	    	}else{
	    		System.out.println("Error. Please enter again.");
	    		System.out.println();
                }
                    
       // System.out.println(dice()); to roll dice
    }
    

    private static void registerMember(long timeEnd) {
        ctrlMaintainPlayer playerControl = new ctrlMaintainPlayer();
        
        String name;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n-Registration-\nPlayer Name:");
        name = scan.nextLine();
        playerControl.addRecord(name, timeEnd);
        if (playerControl.checkName(name) == true){
            System.out.println("Your name has successfully registered. ");
        }else{
            System.out.println("Oh no, your name cannot be register. Please try again later.");
            System.exit(0);
        }
        
    }


    private static void viewRanking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
