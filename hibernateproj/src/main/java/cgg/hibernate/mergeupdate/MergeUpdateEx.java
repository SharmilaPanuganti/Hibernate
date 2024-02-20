package cgg.hibernate.mergeupdate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgg.hibernate.Student;

public class MergeUpdateEx {
    public static void main(String[] args) {
        Student student=null;
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        try (Session session = factory.openSession();) {
           student = session.get(Student.class, 101);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        student.setCity("hyd");
        try (Session session=factory.openSession();) {
            session.beginTransaction();
        Student student2 = session.get(Student.class, 101);
        session.merge(student);
        session.getTransaction().commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        
    }
}
