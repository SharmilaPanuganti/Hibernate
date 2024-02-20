package cgg.tutorial.entitylifecycle;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;

public class DeleteEntity {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            BackupStudent student = session.get(BackupStudent.class, 3);
            if(student!=null){
                session.beginTransaction();
                session.remove(student);
                 session.getTransaction().commit();
            }
            else{
                System.out.println("Student does not exist");
            }
           
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
