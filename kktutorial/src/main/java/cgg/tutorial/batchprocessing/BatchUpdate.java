package cgg.tutorial.batchprocessing;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.inheritance.Person;
import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BatchUpdate {

    public static void main(String[] args) {
        Transaction tx = null;
        ScrollableResults sr = null;
        Session session = HibernateUtil.getfactory().openSession();
        tx = session.beginTransaction();
        int batchsize = 20;
        sr = session
                .createQuery("from Person", Person.class)
                .setCacheMode(CacheMode.IGNORE)
                .scroll(ScrollMode.FORWARD_ONLY);
        int count = 0;

        while (sr.next()) {
            Person p = (Person) sr.get();
            processPerson(p);
            if (++count % batchsize == 0) {
                System.out.println("session is flushed...");
                session.flush();
                session.clear();
            }
        }
        tx.commit();
        session.close();
    }

    private static void processPerson(Person p) {
        p.setGender("Male");
    }
}
