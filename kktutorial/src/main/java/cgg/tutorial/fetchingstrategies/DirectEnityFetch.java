package cgg.tutorial.fetchingstrategies;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;

public class DirectEnityFetch {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        BackupStudent student = session.get(BackupStudent.class, 1);
        if (student != null) {
            System.out.println("Student details: ");
            System.out.println(student);
            if (student.getDepartment() != null) {
                System.out.println("Department details:");
                System.out.println(student.getDepartment());
            } else {
                System.out.println("Student is not in any dept");
            }
        } else {
            System.out.println("Student with the given id does not exist");
        }

        session.close();
    }
}
