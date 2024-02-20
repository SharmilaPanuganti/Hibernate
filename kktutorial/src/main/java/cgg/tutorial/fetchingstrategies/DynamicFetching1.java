package cgg.tutorial.fetchingstrategies;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;

import java.util.Set;

import org.hibernate.Session;

public class DynamicFetching1 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();

        Department students = session
                .createQuery(
                        "select b from Department b left join fetch b.students where b.dept_id=2",
                        Department.class)
                .getSingleResult();
        if (students != null) {
            System.out.println("Departent:" + students.getDept_name());
            System.out.println("Students list");
            Set<BackupStudent> students2 = students.getStudents();
            students2.forEach(System.out::println);
        }
        session.close();
    }
}
