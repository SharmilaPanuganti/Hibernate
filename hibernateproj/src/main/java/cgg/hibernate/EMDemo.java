package cgg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EMDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Student student = new Student(102, "Sharmila", "KNR", new Certificate("Java","3 months"));
        Student student2 = new Student(103, "Sai", "HYD", new Certificate("Full Stack","4 months"));
        Student student3 = new Student(104, "Madhu", "HYD", new Certificate("Full Stack","4 months"));
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student2);
        session.persist(student3);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
