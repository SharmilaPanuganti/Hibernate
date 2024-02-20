package cgg.tutorial.fetchingstrategies;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.Department;

public class FetchJoin {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        Department dept = session.get(Department.class, 2);
        if (dept != null) {
            System.out.println("department: " + dept.getDept_name());
            // System.out.println(dept.getStudents());
            System.out.println("Students count: " + dept.getStudents().size());
        }

        session.close();
    }
}
