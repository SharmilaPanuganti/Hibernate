package cgg.eventlisteners.lockings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import cgg.eventlisteners.HibernateUtil;
import cgg.eventlisteners.entities.Person;

public class LoggerEx {
    private static final Logger logger = LogManager.getLogger(LoggerEx.class);

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getfactory().openSession();) {
            session.beginTransaction();
            Person p = new Person();
            p.setGender("male");
            p.setName("sss");
            // logger.info(" saved");
            // session.saveOrUpdate(p);
            session.persist(p);
            session.getTransaction().commit();
            Person person1 = session.get(Person.class, 1);
            if (person1 != null) {
                session.beginTransaction();
                person1.setGender("female");

                session.merge(person1);
                session.getTransaction().commit();
            }
            System.out.println("------------------------------------------------------------------");

            session.refresh(person1);
        } catch (Exception e) {
            logger.error("Failed to save" + e);
        }

    }
}
