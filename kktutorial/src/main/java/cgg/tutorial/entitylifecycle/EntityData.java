package cgg.tutorial.entitylifecycle;

import java.util.Optional;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;

public class EntityData {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            // BackupStudent student = session.load(BackupStudent.class, 3);
            // if(student!=null)
            // System.out.println(student);
            // session.byNaturalId(BackupStudent.class).using("id", "90889809090-").load();
            Optional<BackupStudent> student = session.byId(BackupStudent.class).loadOptional(3);
            // BackupStudent student = session.byId(BackupStudent.class).load(3);
            System.out.println(student);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
