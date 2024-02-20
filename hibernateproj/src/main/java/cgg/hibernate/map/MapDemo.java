package cgg.hibernate.map;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        
    
    SessionFactory factory=new Configuration().configure().buildSessionFactory();
    Answer a1=new Answer(101, "Pragramming language");
    Answer a2=new Answer(102, "API to work with group of objects");
    // Answer a3=new Answer(103, "to develop software");
    // Answer a4=new Answer(104, "Api is improved and efiicient");
    
    // Question q1 = new Question(1,"What is java?");
    // Question q2 = new Question(2,"What is CollectionFramework?");
    // Question q3 = new Question(3,"What is NetBeans?");
    
//    a1.setQuestion(q1);
//    a2.setQuestion(q2);
//    a3.setQuestion(q1);
//    a4.setQuestion(q2);
    Session session=factory.openSession();
    session.beginTransaction();
    // session.persist(q1);
    // session.persist(q2);
    // session.persist(a1);
    // session.persist(a3);
    // session.persist(a4);
    // session.persist(a2);
    Question q1 = session.get(Question.class, 1);
    // Question q2 = session.get(Question.class, 2);
    // q1.setAnswer(a1);
    // q2.setAnswer(a2);
    // session.merge(q1);
    // session.merge(q2);
    List<Answer> answers = q1.getAnswer();
    for (Answer answer : answers) {
        System.out.println(answer);
    }
    session.getTransaction().commit();
    factory.close();
    session.close();
    }
}
