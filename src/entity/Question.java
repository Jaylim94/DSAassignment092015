
package entity;

/**
 *
 * @author Jaylim
 */
public class Question {
    int questionID;
    String question;
    int answer;
    String answerStatement;

    public Question(int questionID, String question, int answer, String answerStatement) {
        this.questionID = questionID;
        this.question = question;
        this.answer = answer;
        this.answerStatement = answerStatement;
    }

    public Question() {
    }

    public int getQuestionID() {
        return questionID;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public String getAnswerStatement() {
        return answerStatement;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setAnswerStatement(String answerStatement) {
        this.answerStatement = answerStatement;
    }

    @Override
    public String toString() {
        return "QuestionDatabase{" + "questionID=" + questionID + ", question=" + question + ", answer=" + answer + ", answerStatement=" + answerStatement + '}';
    }
    
    
}
