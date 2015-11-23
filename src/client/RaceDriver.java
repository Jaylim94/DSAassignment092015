
package client;

import controller.ctrlMaintainPlayer;
import entity.Player;
import java.util.Random;

/**
 *
 * @author Jaylim
 */
public class RaceDriver {
    Player player = new Player();
    ctrlMaintainPlayer playerControl = new ctrlMaintainPlayer();
    
    public static void main(String[] args) { 
        
       for(int i=0; i<50; i++)
        System.out.println(dice());
       
    }
    
    public static int dice() {

        Random rand = new Random();
        int randomNum;

        do{
            randomNum = rand.nextInt(6) -2 ;
        }while (randomNum == 0);

        return randomNum;
    }
    
    
    
    
}
