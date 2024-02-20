package cgg.tutorial.inheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveClient3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Person p=new Person();
        p.setName("Sudha");
        p.setGender("female");
        Worker w=new Worker();
        w.setDept_name("Development");
        w.setDesignation("SD");
        w.setName("ABc");
        w.setGender("female");
        Pupil p2=new Pupil();
        p2.setDob(new Date());
        p2.setSchool_name("BMS");
        p2.setName("xyz");
        p2.setGender("male");
        session.beginTransaction();
        session.persist(p);
        session.persist(w);
        session.persist(p2);
        session.getTransaction().commit();
        session.close();
    }
}
