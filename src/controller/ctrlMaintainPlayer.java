package controller;

import database.PlayerDatabase;
import entity.Player;

public class ctrlMaintainPlayer {

    private PlayerDatabase playerDA;

    public ctrlMaintainPlayer() {
        playerDA = new PlayerDatabase();
    }
    
    public Player selectRecord(int id) {
        return playerDA.getRecord(id);
    }
    
    public void addRecord(String name, long timeEnd) {
        playerDA.addRecord(name, timeEnd);
    }
    
    public void updateRecord(Player p) {
        playerDA.updateRecord(p);
    }
    
    public void deleteRecord(int id) {
        playerDA.deleteRecord(id);
    }
    
    public boolean checkName(String name){
        return playerDA.checkName(name);
    }

}
