package cgg.hibernate.xmlmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Person p=new Person();
        p.setName("Sharmila");
        p.setPhone("9098989309");
        session.beginTransaction();
        session.persist(p);
        session.getTransaction().commit();
        session.close();
    }
}
