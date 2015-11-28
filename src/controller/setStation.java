
package controller;

import adt.StationList;
import entity.Station;
import adt.StationListInterface;

public class setStation {
    Station stationA, stationB, stationC, stationD = new Station();  
    String describe = "Please choose the correct answer in the following MCQ Questions";
    StationListInterface<Station> listStation = new StationList<>();
    
    public void setStation(){

        stationA.setStationName("Station A");
        stationB.setStationName("Station B");
        stationC.setStationName("Station C");
        stationD.setStationName("Station D");
        
        stationA.setStationDescription(describe);
        stationB.setStationDescription(describe);
        stationC.setStationDescription(describe);
        stationD.setStationDescription(describe);
        
        listStation.insertAtStart(new Station("Start Position"));
        listStation.insertAtEnd(stationA);
        listStation.insertAtEnd(stationB);
        listStation.insertAtEnd(stationC);
        listStation.insertAtEnd(stationD);
        listStation.insertAtEnd(new Station("Finishing Point"));
    }


}
