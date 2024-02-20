package cgg.tutorial.batchprocessing;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.inheritance.Person;
import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

public class StatelessBatch {

    public static void main(String[] args) {
        Transaction tx = null;
        ScrollableResults sr = null;
        StatelessSession session = HibernateUtil.getfactory().openStatelessSession();
        tx = session.getTransaction();
        tx.begin();
        // int batchsize = 20;
        sr = session
                .createQuery("from Person", Person.class)
                .scroll(ScrollMode.FORWARD_ONLY);
        // int count = 0;

        while (sr.next()) {
            Person p = (Person) sr.get();
            processPerson(p);
            session.update(p);
        }
        tx.commit();
        sr.close();
        session.close();
    }

    private static void processPerson(Person p) {
        p.setGender("Male");
    }
}
