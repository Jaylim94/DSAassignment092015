
package adt;
/**
 *
 * @author Jaylim
 */
public class stopWatch {
    long startTime, endTime, time;
    
    public void start(){
        startTime = System.currentTimeMillis();
    }
    
    public void end(){
        endTime = System.currentTimeMillis() - startTime;
        time = ((endTime/ 1000) % 60);
    }
    
    public int timeSpend(){
        return (int)time;
    }
    
    @Override
    public String toString() {
        return ("Time Spend = " + time  + " seconds") ;
    }
    

}
