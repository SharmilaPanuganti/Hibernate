package cgg.tutorial.lockings;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.inheritance.Person;

public class OptimisticLocktext {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                Session session = HibernateUtil.getfactory().openSession();
                Person p = session.get(Person.class, 1);
                if (p != null) {
                    session.beginTransaction();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    p.setName("Sharmila Srinivas");

                    session.merge(p);
                    session.getTransaction().commit();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                Session session = HibernateUtil.getfactory().openSession();
                Person p = session.get(Person.class, 1);
                if (p != null) {
                    session.beginTransaction();
                    p.setName("Sharmi");
                    session.merge(p);
                    session.getTransaction().commit();
                }
            }
        });
        t1.start();
        t2.start();

    }
}
