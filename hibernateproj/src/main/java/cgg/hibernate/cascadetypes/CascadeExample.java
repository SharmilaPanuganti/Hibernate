package cgg.hibernate.cascadetypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgg.hibernate.map.Answer;
import cgg.hibernate.map.Question;

public class CascadeExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Question q = new Question();
        q.setQuestion("what is cascading?");
        q.setQuestionId(102);
        Answer a1 = new Answer(104, "cascading is important");
        Answer a2 = new Answer(105, "cascading  in hibernate");
        a1.setQuestion(q);
        a2.setQuestion(q);
        q.getAnswer().add(a2);
        q.getAnswer().add(a1);
        session.beginTransaction();
        session.persist(q);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
