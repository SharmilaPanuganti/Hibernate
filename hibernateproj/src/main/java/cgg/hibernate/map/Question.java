package cgg.hibernate.map;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="question")
public class Question {
   
    @Id
    @Column(name = "question_id")
    private int questionId;
   
    private String question;
   
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Answer> answers=new ArrayList<>();
    public Question(int questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }
    public List<Answer> getAnswer() {
        return answers;
    }
    public void setAnswer(List<Answer> answers) {
        this.answers = answers;
    }
    
    public Question() {
    }
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
     @Override
    public String toString() {
        return "Question:" + question + ", answers=" + answers ;
    }
    public Question(int questionId, String question, List<Answer> answers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }
    
}
