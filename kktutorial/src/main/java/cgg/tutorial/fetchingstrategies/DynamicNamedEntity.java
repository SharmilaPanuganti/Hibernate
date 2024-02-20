package cgg.tutorial.fetchingstrategies;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;
import java.util.Collections;
import java.util.Set;
import org.hibernate.Session;

public class DynamicNamedEntity {

    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();

        Department students = session.find(
                Department.class,
                2,
                Collections.singletonMap(
                        "jakarta.persistence.fetchgraph",
                        session.getEntityGraph("dept.students")));

        // subgraphs
        if (students != null) {
            System.out.println("Department:" + students.getDept_name());
            System.out.println("Students list");
            Set<BackupStudent> students2 = students.getStudents();
            students2.forEach(System.out::println);
        }
        session.close();
    }
}
