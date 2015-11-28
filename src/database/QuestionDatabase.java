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
        String insertStr = "INSERT INTO " + tableName + " (QUESTION, CORRECTANSWER, SELECTION1, SELECTION2, SELECTION3, SELECTION4) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, question.getQuestion());
            stmt.setInt(2, question.getCorrentAnswer());
            stmt.setString(3, question.getSelection1());
            stmt.setString(4, question.getSelection2());
            stmt.setString(5, question.getSelection3());
            stmt.setString(6, question.getSelection4());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR addRecord Question", JOptionPane.ERROR_MESSAGE);
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
                question = new Question(qNumber, rs.getString("QUESTION"), rs.getInt("CORRECTANSWER"), rs.getString("SELECTION1"), rs.getString("SELECTION2"), rs.getString("SELECTION3"), rs.getString("SELECTION4"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR getRecord Question", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR getQuestion Question", JOptionPane.ERROR_MESSAGE);
        }
        return questionQ;
    }
    
    public String getAnsState1(int aSnumber) {
        String queryStr = "SELECT SELECTION1 FROM " + tableName + " WHERE QUESTIONID = ?";
        String questionQ = "";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, aSnumber);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                questionQ = rs.getString("SELECTION1");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR getAnsStatement1 Question", JOptionPane.ERROR_MESSAGE);
        }
        return questionQ;
    }
    
    public String getAnsState2(int aSnumber) {
        String queryStr = "SELECT SELECTION2 FROM " + tableName + " WHERE QUESTIONID = ?";
        String questionQ = "";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, aSnumber);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                questionQ = rs.getString("SELECTION2");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR getAnsStatement2 Question", JOptionPane.ERROR_MESSAGE);
        }
        return questionQ;
    }
    
    public String getAnsState3(int aSnumber) {
        String queryStr = "SELECT SELECTION3 FROM " + tableName + " WHERE QUESTIONID = ?";
        String questionQ = "";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, aSnumber);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                questionQ = rs.getString("SELECTION3");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR getAnsStatement3 Question", JOptionPane.ERROR_MESSAGE);
        }
        return questionQ;
    } 
    
    public String getAnsState4(int aSnumber) {
        String queryStr = "SELECT SELECTION4 FROM " + tableName + " WHERE QUESTIONID = ?";
        String questionQ = "";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, aSnumber);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                questionQ = rs.getString("SELECTION4");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR getAnsStatement4 Question", JOptionPane.ERROR_MESSAGE);
        }
        return questionQ;
    } 
    
    public int generateAnswer(int qNo) {
        String queryStr = "SELECT CORRECTANSWER FROM " + tableName + " WHERE QUESTIONID = ?";
        int answer = 0;
        
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1, qNo);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                answer = rs.getInt("CORRECTANSWER");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR generateAnswer Question", JOptionPane.ERROR_MESSAGE);
        }
        return answer;
    }

    public void updateRecord(Question question) {
        try {
            String updateStr = "UPDATE " + tableName + " SET QUESTION = ?, CORRECTANSWER = ?, SELECTION1 = ?, SELECTION2 = ?, SELECTION3 = ?, SELECTION4 = ? WHERE QUESTIONID = ?";

            stmt = conn.prepareStatement(updateStr);

            stmt.setString(1, question.getQuestion());
            stmt.setInt(2, question.getCorrentAnswer());
            stmt.setString(3, question.getSelection1());
            stmt.setString(4, question.getSelection2());
            stmt.setString(5, question.getSelection3());
            stmt.setString(6, question.getSelection4());
            stmt.setInt(7, question.getQuestionID());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR updateRecord Question", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR deleteRecord Question", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established for Question Database.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR createConnection Question", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR shutDown Question", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        QuestionDatabase playerDB = new QuestionDatabase();
    }
}
