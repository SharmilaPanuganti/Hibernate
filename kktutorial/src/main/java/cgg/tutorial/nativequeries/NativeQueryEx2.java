package cgg.tutorial.nativequeries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;

public class NativeQueryEx2 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        NativeQuery query = session.createNativeQuery("select * from student_backup").addEntity(BackupStudent.class);
        List<BackupStudent> res = query.getResultList();
        for (BackupStudent object : res) {
            System.out.println(object);
        }
        session.close();
    }
}
