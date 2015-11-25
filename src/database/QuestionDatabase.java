package database;

import java.sql.*;
import javax.swing.*;
import entity.Question;

public class QuestionDatabase {

    private String host = "jdbc:derby://localhost:1527/dsa2015db";
    private String user = "jaylim";
    private String password = "jaylim";
    private String tableName = "Question";
    private Connection conn;
    private PreparedStatement stmt;

    public QuestionDatabase() {
        createConnection();
    }

    public void addRecord(Question question) {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setInt(1, question.getQuestionID());
            stmt.setString(2, question.getQuestion());
            stmt.setString(3, question.getAnswer().toString());
            stmt.setString(4, question.getAnswerStatement());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Question getRecord(int qNumber) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE QUESTIONID = ?";
        Question question = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, qNumber);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                question = new Question(qNumber, rs.getString("QUESTION"), rs.getString("ANSWER").charAt(0), rs.getString("ANSWERSTATEMENT"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return question;
    }
    
    public String getQuestion(int qNumber) {
        String queryStr = "SELECT QUESTION FROM " + tableName + " WHERE QUESTIONID = ?";
        String questionQ = "";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, qNumber);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                questionQ = rs.getString("QUESTION");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return questionQ;
    }

    public void updateRecord(Question question) {
        try {
            String updateStr = "UPDATE " + tableName + " SET QUESTION = ?, ANSWER = ?, ANSWERSTATEMENT = ? WHERE QUESTIONID = ?";

            stmt = conn.prepareStatement(updateStr);

            stmt.setString(1, question.getQuestion());
            stmt.setString(2, question.getAnswer().toString());
            stmt.setString(3, question.getAnswerStatement());
            stmt.setInt(4, question.getQuestionID());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println("******ERROR: " + ex.getMessage());
        }
    }

    public void deleteRecord(int qNumber) {
        try {
            String deleteStr = "DELETE FROM " + tableName + " WHERE QUESTIONID = ?";
            stmt = conn.prepareStatement(deleteStr);
            stmt.setInt(1, qNumber);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        QuestionDatabase playerDB = new QuestionDatabase();
    }
}
