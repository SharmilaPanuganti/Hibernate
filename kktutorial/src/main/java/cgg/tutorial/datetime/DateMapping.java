package cgg.tutorial.datetime;

import java.util.Date;
import java.util.TimeZone;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;

public class DateMapping {
    public static void main(String[] args) {
        BackupStudent bp = new BackupStudent();
        bp.setDob(new Date());
        bp.setMarks(950.00);
        bp.setName("Sharmi");
        Department d = new Department();
        d.setDept_name("EEE");
        d.getStudents().add(bp);
        bp.setDepartment(d);
        // Session session = HibernateUtil.getfactory().openSession();
        Session session = HibernateUtil.getfactory().withOptions().jdbcTimeZone(TimeZone.getTimeZone("UTC"))
                .openSession();

        session.beginTransaction();
        session.persist(d);
        session.getTransaction().commit();
    }
}
