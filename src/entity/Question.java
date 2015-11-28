
package entity;

/**
 *
 * @author Jaylim
 */
public class Question {
    int questionID;
    String question;
    int correntAnswer;
    String selection1;
    String selection2;
    String selection3;
    String selection4;

    public Question(int questionID, String question, int correntAnswer, String selection1, String selection2, String selection3, String selection4) {
        this.questionID = questionID;
        this.question = question;
        this.correntAnswer = correntAnswer;
        this.selection1 = selection1;
        this.selection2 = selection2;
        this.selection3 = selection3;
        this.selection4 = selection4;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCorrentAnswer() {
        return correntAnswer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public void setCorrentAnswer(int correntAnswer) {
        this.correntAnswer = correntAnswer;
    }

    public String getSelection1() {
        return selection1;
    }

    public void setSelection1(String selection1) {
        this.selection1 = selection1;
    }

    public String getSelection2() {
        return selection2;
    }

    public void setSelection2(String selection2) {
        this.selection2 = selection2;
    }

    public String getSelection3() {
        return selection3;
    }

    public void setSelection3(String selection3) {
        this.selection3 = selection3;
    }

    public String getSelection4() {
        return selection4;
    }

    public void setSelection4(String selection4) {
        this.selection4 = selection4;
    }

    @Override
    public String toString() {
        return "Question{" + "question=" + question + ", correntAnswer=" + correntAnswer + ", selection1=" + selection1 + ", selection2=" + selection2 + ", selection3=" + selection3 + ", selection4=" + selection4 + '}';
    }
    
    

}
