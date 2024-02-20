package cgg.tutorial.fetchingstrategies;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.Department;
import java.util.List;
import org.hibernate.Session;

public class FetchModeEx {

    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        List<Department> depts = session
                .createQuery("from Department", Department.class)
                .getResultList();
        System.out.println("Department size: " + depts.size());
        for (Department department : depts) {
            System.out.println("DEpartment : " + department.getDept_name());
            System.out.println("Students count: " + department
                    .getStudents().size());
        }
        session.close();
    }
}
