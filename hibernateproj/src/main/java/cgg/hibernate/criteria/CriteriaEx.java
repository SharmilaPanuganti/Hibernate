package cgg.hibernate.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgg.hibernate.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaEx {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Student> cr = cb.createQuery(Student.class);

Root<Student> from = cr.from(Student.class);
cr.select(from).where(cb.equal(from.get("id"),101));
cr.getRestriction();
Query<Student> query = session.createQuery(cr);
List<Student> resultList = query.getResultList();
for (Student student : resultList) {
    System.out.println(student);
}
session.close();
factory.close();
    }
}
