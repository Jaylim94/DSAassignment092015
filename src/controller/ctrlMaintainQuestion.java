package controller;

import database.QuestionDatabase;
import entity.Question;
import database.QuestionDatabase;

public class ctrlMaintainQuestion {

    private QuestionDatabase questionDA;

    public ctrlMaintainQuestion() {
        questionDA = new QuestionDatabase();
    }
    
    public Question selectRecord(int id) {
        return questionDA.getRecord(id);
    }
    
    public String getQuestion(int number) {
        return questionDA.getQuestion(number);
    }
    
    public int getAnswer(int qNo){
        return questionDA.generateAnswer(qNo);
    }
    
    public String getSelection1(int ansStatement){
        return questionDA.getAnsState1(ansStatement);
    }
    public String getSelection2(int ansStatement){
        return questionDA.getAnsState2(ansStatement);
    }    
    public String getSelection3(int ansStatement){
        return questionDA.getAnsState3(ansStatement);
    }
    public String getSelection4(int ansStatement){
        return questionDA.getAnsState4(ansStatement);
    }   
    
    public void addRecord(Question q) {
        questionDA.addRecord(q);
    }
    
    public void updateRecord(Question q) {
        questionDA.updateRecord(q);
    }
    
    public void deleteRecord(int id) {
        questionDA.deleteRecord(id);
    }

}
