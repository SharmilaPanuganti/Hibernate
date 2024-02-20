package cgg.tutorial.fetchingstrategies;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

public class BatchFetching {

    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        // List<Department> depts = session.createQuery("from Department",
        // Department.class).getResultList();
        List<Department> depts = session
                .createQuery(
                        "select b from Department b left join fetch b.students ",
                        Department.class) // n+1 problem solution criteria builder use root.fetch("attribute",join)
                .getResultList();
        for (Department department : depts) {
            System.out.println("DEpartment details");
            System.out.println(department);
            System.out.println("Student details");
            Set<BackupStudent> students = department.getStudents();
            students.forEach(System.out::println);
        }
        session.close();
    }
}
