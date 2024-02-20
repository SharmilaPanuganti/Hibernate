package cgg.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgg.hibernate.Student;

public class FirstLevelCache {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Student student = session.get(Student.class, 101);
        System.out.println(student);
        Student student2 = session.get(Student.class, 101);
        System.out.println(student2);
        session.close();
        factory.close();
    }
}
