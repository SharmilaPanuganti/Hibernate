package cgg.tutorial.lockings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.inheritance.Person;

public class LoggerEx {
    private static final Logger logger = LogManager.getLogger(LoggerEx.class);

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getfactory().openSession();) {
            session.beginTransaction();
            Person p = new Person();
            p.setName("Sharmila");
            p.setGender("female");
            Person p2 = new Person();
            p2.setName("Madhu");
            p2.setGender("female");
            session.saveOrUpdate(p);
            session.persist(p2);
            // logger.info(" saved");

            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Failed to save" + e);
        }

    }
}
