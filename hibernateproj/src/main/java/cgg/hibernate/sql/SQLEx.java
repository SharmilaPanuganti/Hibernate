package cgg.hibernate.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import cgg.hibernate.Student;

public class SQLEx {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // NativeQuery<Student> query = session.createNativeQuery("select * from student",Student.class);
        // List<Student> list = query.getResultList();
        // for (Student student : list) {
        //     System.out.println(student);
        // }
        NativeQuery<Object[]> query2 = session.createNativeQuery("select id,name,city from student where city=?", Object[].class);
          query2.setParameter(1,"Drm");
          List<Object[]> resultList = query2.getResultList();
          for (Object[] objects : resultList) {
            System.out.println(objects[0]+"  "+objects[1]+"  "+objects[2]);
          }
         session.close();
         factory.close();
    }
}
