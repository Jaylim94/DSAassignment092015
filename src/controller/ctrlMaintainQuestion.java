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
