package cgg.tutorial.hql;

import java.util.Date;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;

public class SaveClient2 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        BackupStudent s1 = new BackupStudent();
        s1.setDob(new Date());
        s1.setName("Sharmi");
        s1.setMarks(900.02);
        BackupStudent s2 = new BackupStudent();
        s2.setName("Sai");
        s2.setDob(new Date());
        s2.setMarks(920.02);
        BackupStudent s3 = new BackupStudent();
        s3.setDob(new Date());
        s3.setName("Sharmila");
        s3.setMarks(960.02);
        BackupStudent s4 = new BackupStudent();
        s4.setName("Sai Teja");
        s4.setDob(new Date());
        s4.setMarks(950.35);
        Department d1 = new Department();
        d1.setDept_name("CSE");
        d1.getStudents().add(s2);
        d1.getStudents().add(s1);
        Department d2 = new Department();
        d2.setDept_name("EEE");
        d2.getStudents().add(s3);
        d2.getStudents().add(s4);
        s1.setDepartment(d1);
        s2.setDepartment(d1);
        s3.setDepartment(d2);
        s4.setDepartment(d2);
        session.beginTransaction();
        session.persist(d1);
        // int save = (int) session.save(d1);
        session.persist(d2);
        session.getTransaction().commit();
        // Department department = session.get(Department.class, save);
        // System.out.println(department);

        session.close();
    }

}
