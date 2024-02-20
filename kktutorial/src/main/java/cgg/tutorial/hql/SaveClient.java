package cgg.tutorial.hql;

import java.util.Date;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;

public class SaveClient {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            
            session.beginTransaction();
            Address a1=new Address();
            a1.setCity("hyd");
            a1.setPincode(50094l);
            a1.setStreet_name("Gandhi street");
            Address a2=new Address();
            a2.setCity("KNR");
            a2.setPincode(50032l);
            a2.setStreet_name("Ram nagar");
            Student s1=new Student();
            s1.setName("Sharmi");
            s1.setDob(new Date());
            s1.setMarks(890.95);
            s1.setAddress(a1);
            Student s2=new Student();
            s2.setName("Sai");
            s2.setDob(new Date());
            s2.setMarks(920.02);
            s2.setAddress(a2);
            session.persist(s1);
            session.persist(s2);
            session.getTransaction().commit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
