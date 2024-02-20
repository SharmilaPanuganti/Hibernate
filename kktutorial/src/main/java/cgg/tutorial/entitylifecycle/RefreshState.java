package cgg.tutorial.entitylifecycle;

import java.sql.Statement;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;

public class RefreshState {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getfactory().openSession()) {
            BackupStudent student = session.byId(BackupStudent.class).load(1);
            session.doWork(conn->{
                try(Statement stm=conn.createStatement()) {
                    stm.executeUpdate("update student_backup set name=lower(name)");
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            });
            session.refresh(student);
            System.out.println(student.getName());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
