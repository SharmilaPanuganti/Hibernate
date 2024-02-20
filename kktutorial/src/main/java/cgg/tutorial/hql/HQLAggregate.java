package cgg.tutorial.hql;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import cgg.tutorial.HibernateUtil;

public class HQLAggregate {
    public static void main(String[] args) {
        Session session=HibernateUtil.getfactory().openSession();
        // String hql="Select COUNT(bs),AVG(bs.marks),Min(bs.marks),sum(bs.marks)  from BackupStudent bs";
        String hql="Select new cgg.tutorial.hql.StudentStatistics (COUNT(bs),AVG(bs.marks),Min(bs.marks),sum(bs.marks))  from BackupStudent bs";
        
        // Query<Object[]> query = session.createQuery(hql,Object[].class);
        Query<StudentStatistics> query = session.createQuery(hql,StudentStatistics.class);
        // List<Object[]> list = query.list();
        // for (Object[] objects : list) {
        //     System.out.println("No.of Students: "+objects[0]+"\nAverage marks: "+objects[1]+"\nMinimum marks: "+objects[2]+"\nSum: "+objects[3]);
        // }
        StudentStatistics res = query.uniqueResult();
        System.out.println(res);
        session.close();
    }
}
