package cgg.hibernate.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgg.hibernate.Student;

public class PaginationEx {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        Query<Student> query = session.createQuery("from Student",Student.class);
        //implementing pagination
        query.setFirstResult(4);
        query.setMaxResults(5);
        List<Student> res = query.list();
        // res.forEach(s->System.out.println(s));
        for (Student student : res) {
            System.out.println(student);
        }
        session.close();
        factory.close();
    }
}
