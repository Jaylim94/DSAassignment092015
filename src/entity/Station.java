//Jaylim

package entity;

public class Station {
    
    private String stationName;
    private String stationDescription; 
    private boolean playerIsHere;

    public Station(String stationName, String stationDescription, boolean playerIsHere) {
        this.stationName = stationName;
        this.stationDescription = stationDescription;
        this.playerIsHere = playerIsHere;
    }

    public Station(String stationName) {
        this.stationName = stationName;
        playerIsHere = false;
    }

    public Station() {
    }
    
    

    public String getStationName() {
        return stationName;
    }

    public String getStationDescription() {
        return stationDescription;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setStationDescription(String stationDescription) {
        this.stationDescription = stationDescription;
    }

    public void updatePlayerPosition(boolean stationIsHere) {
        this.playerIsHere = stationIsHere;
    }
    
    public String display(){
        if(playerIsHere)
            return stationName + " | You are here";
        else
            return stationName;
    }
}
