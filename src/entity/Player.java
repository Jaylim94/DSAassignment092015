/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 * @author Jaylim
 */
package entity;

public class Player {
    private int playerID;
    private String playerName;
    private long timeUsed;

    public Player(int playerId, String playerName, long timeUsed) {
        this.playerID = playerId;
        this.playerName = playerName;
        this.timeUsed = timeUsed;
    }

    public Player() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public long getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(long timeUsed) {
        this.timeUsed = timeUsed;
    }

    @Override
    public String toString() {
        return "Player{" + "playerID=" + playerID + ", playerName=" + playerName + ", timeUsed=" + timeUsed + '}';
    }


    
}
