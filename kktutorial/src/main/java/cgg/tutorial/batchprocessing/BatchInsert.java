package cgg.tutorial.batchprocessing;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.inheritance.Person;

public class BatchInsert {
    public static void main(String[] args) {
        Transaction tx = null;
        Session session = HibernateUtil.getfactory().openSession();
        tx = session.beginTransaction();
        int batchsize = 20;
        for (int i = 0; i < 1000; i++) {
            Person p = new Person();
            p.setName("person " + i);
            p.setGender("female");
            session.persist(p);
            if (i > 0 && i % batchsize == 0) {
                session.flush();
                session.clear();
            }
        }
        tx.commit();
        session.close();
    }
}
