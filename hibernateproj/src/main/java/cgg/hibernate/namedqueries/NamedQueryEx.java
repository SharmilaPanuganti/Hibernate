package cgg.hibernate.namedqueries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import cgg.hibernate.Student;

public class NamedQueryEx {
    public static void main(String[] args) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        // Query query = session.getNamedQuery("Student.byId");
    //   NativeQuery query = session.getNamedNativeQuery("Student.byName");
      NativeQuery<Student> query = session.getNamedNativeQuery("Student.byName");
      
              query.setParameter("n", "abc");
        List<Student> list = query.list();
        for (Student student : list) {
            System.out.println(student);
        }
        session.close();
    }
}
