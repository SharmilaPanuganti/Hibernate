package cgg.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgg.hibernate.Certificate;
import cgg.hibernate.Student;

public class StateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Student student=new Student();
        student.setId(102);
        student.setName("Sharmila");
        student.setCity("HYD");
        student.setCertificate(new Certificate("Java", "3 months"));
        //transient state:neither in db nor session

        Session session = factory.openSession();
        session.beginTransaction();
        //  session.persist(student);  
          //persistent state:session,db
          student.setName("Sharmila Panuganti");
          Student student2 = session.get(Student.class, 102);
          session.remove(student2);  //removed state
          
        session.getTransaction().commit();
        session.close();
        //detached state
        
        student.setCity("DRM");

        factory.close();

    }
}
