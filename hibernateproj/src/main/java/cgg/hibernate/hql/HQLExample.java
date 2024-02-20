package cgg.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import cgg.hibernate.Student;

public class HQLExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // HQL
        String query = "from Student as s where s.city=:x and s.name=:y";
        Query query2 = session.createQuery(query);
        query2.setParameter("x", "DRM");
        query2.setParameter("y", "Sharmila");
        List<Student> list = query2.list();
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("------------------------------------------------");
        session.beginTransaction();

        //delete
        // Query query3 = session.createQuery("delete from Student s where s.city=:c and s.name=:n");
        // query3.setParameter("c", "HYD");
        // query3.setParameter("n", "Sai");
        // int res = query3.executeUpdate();
        // System.out.println("deleted :" + res);

        //update
        // Query query3 = session.createQuery("update Student s set s.city=:c where id=:i");
        // query3.setParameter("c", "HYD");
        // query3.setParameter("i", 101);
        // int res = query3.executeUpdate();
        // System.out.println("Updated:"+res);

        //join query
        Query<Object[]> query3 = session.createQuery("select q.question,q.questionId,a.answer from Question q INNER JOIN q.answers a",Object[].class);
        // List<Object[]> resultList = query3.list();
        List<Object[]> resultList = query3.getResultList();
        for (Object[] objects : resultList) {
            System.out.println(Arrays.toString(objects));
        }
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
