package cgg.tutorial.flush;

import java.math.BigInteger;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.inheritance.Person;

public class ManualAlways {
    public static void main(String[] args) {
        Session openSession = HibernateUtil.getfactory().openSession();
        openSession.setHibernateFlushMode(FlushMode.MANUAL);
        Person p = new Person();
        p.setGender("female");
        p.setName("Sharmila");
        openSession.beginTransaction();
        openSession.persist(p);
        openSession.flush();
        BigInteger res = openSession.createNativeQuery("select count(*) from person", BigInteger.class).uniqueResult();
        System.out.println(res);

        openSession.getTransaction().commit();
        openSession.close();
    }
}
