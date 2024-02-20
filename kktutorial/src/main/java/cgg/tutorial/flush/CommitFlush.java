package cgg.tutorial.flush;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.inheritance.Person;
import jakarta.persistence.FlushModeType;
import org.hibernate.Session;

public class CommitFlush {

    public static void main(String[] args) {
        Session openSession = HibernateUtil.getfactory().openSession();
        Person p = new Person();
        p.setGender("female");
        p.setName("Sharmila");
        openSession.beginTransaction();
        openSession.persist(p);
        openSession.getTransaction().commit();
        openSession
                .createQuery(" from BackupStudent", BackupStudent.class)
                .setFlushMode(FlushModeType.COMMIT)
                .getResultList();
        openSession
                .createQuery(" from Person", Person.class)
                .setFlushMode(FlushModeType.COMMIT)
                .getResultList();

        openSession.close();
    }
}
