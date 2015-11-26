/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Jaylim
 */

public class Station {
    private String missionQuestion = "";
    private String missionAnswer = "";
    private String stationName;
    private boolean playerIsHere;

    public Station(String stationName) {
        this.stationName = stationName;
        this.playerIsHere = false;
    }

    public String getMissionQuesiton() {
        return this.missionQuestion;
    }

    public void setMissionQuesiton(String missionQuesiton) {
        this.missionQuestion = missionQuesiton;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getMissionAnswer() {
        return this.missionAnswer;
    }

    public void setMissionAnswer(String missionAnswer) {
        this.missionAnswer = missionAnswer;
    }

    public void updatePlayerPosition(boolean stationIsHere) {
        this.playerIsHere = stationIsHere;
    }

    public String display() {
        if (this.playerIsHere) {
            return this.stationName + " | You are here";
        }
        return this.stationName;
    }
}
