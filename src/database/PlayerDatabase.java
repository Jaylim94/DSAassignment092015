package database;

import java.sql.*;
import javax.swing.*;
import entity.Player;

public class PlayerDatabase {

    private String host = "jdbc:derby://localhost:1527/dsa2015db";
    private String user = "jaylim";
    private String password = "jaylim";
    private String tableName = "Player";
    private Connection conn;
    private PreparedStatement stmt;

    public PlayerDatabase() {
        createConnection();
    }

    public void addRecord(String name) {
        String insertStr = "INSERT INTO " + tableName + " (PLAYERNAME) VALUES(?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, name);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR addRecord Player", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Player getRecord(int number) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PLAYERID = ?";
        Player player = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, number);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                player = new Player(number, rs.getString("Name"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR getRecord Player", JOptionPane.ERROR_MESSAGE);
        }
        return player;
    }
    
    public boolean checkName(String name) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PLAYERNAME = ?";
        String databaseName ="";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            databaseName = rs.getString("PLAYERNAME");

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR checkName Player", JOptionPane.ERROR_MESSAGE);
        }
        
        if(databaseName == name){
            return true;
        }else{
            return false;
        }  
    }

    public void updateRecord(Player player) {
        try {
            String updateStr = "UPDATE " + tableName + " SET NAME = ? WHERE PLAYERID = ?";

            stmt = conn.prepareStatement(updateStr);

            stmt.setString(1, player.getName());
            stmt.setInt(2, player.getNumber());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR updateRecord Player", JOptionPane.ERROR_MESSAGE);
            System.out.println("******ERROR: " + ex.getMessage());
        }
    }

    public void deleteRecord(int number) {
        try {
            String deleteStr = "DELETE FROM " + tableName + " WHERE PLAYERID = ?";
            stmt = conn.prepareStatement(deleteStr);
            stmt.setInt(1, number);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR deleteRecord Player", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established for Player Database.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR CreateConnection Player", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR shutdown Player", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        PlayerDatabase playerDB = new PlayerDatabase();
    }
}
