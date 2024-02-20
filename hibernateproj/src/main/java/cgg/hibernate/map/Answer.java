package cgg.hibernate.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {
    @Id
    @Column(name="answer_id")
    private Integer answerId;
    private String answer;
    @ManyToOne
    @JoinColumn(name="q_id")
    private Question question;
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    public Answer(Integer answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }
    public Answer() {
    }
    public Integer getAnswerId() {
        return answerId;
    }
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Override
    public String toString() {
        return "Answer [answer=" + answer + "]";
    }
    
}
