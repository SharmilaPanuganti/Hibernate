package cgg.tutorial.nativeCollections;

import java.util.Date;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;

public class SaveClientTest4 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        Person2 p1=new Person2();
        p1.setName("Sharmi");
        Phone ph=new Phone();
        ph.setNumber("800898978");
        ph.setPerson(p1);
        p1.getPhones().add(ph);
        Call c=new Call();
        c.setDate(new Date());
        c.setPhone(ph);
        Call c2=new Call();
        c2.setDate(new Date());
        c2.setPhone(ph);
        ph.getCalls().add(c2);
        ph.getCalls().add(c);
        Phone ph2=new Phone();
        ph2.setNumber("908098090");
        ph2.setPerson(p1);
        Call c3=new Call();
        c3.setDate(new Date());
        c3.setPhone(ph2);
        Call c4=new Call();
         c4.setDate(new Date());
          c4.setPhone(ph2);
          ph2.getCalls().add(c4);
          ph2.getCalls().add(c3);
          p1.getPhones().add(ph2);
        
        session.beginTransaction();
        session.persist(p1);
        session.getTransaction().commit();
        session.close();


    }
}
