package cgg.tutorial.lockings;

import cgg.tutorial.HibernateUtil;

import cgg.tutorial.inheritance.Person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class LoggerInterceptorDemo {
    private static final Logger logger = LogManager.getLogger(LoggerInterceptorDemo.class);

    public static void main(String[] args) {
        try (Session session = HibernateUtil
                .getfactory()
                .withOptions()
                .interceptor(new LoggerInterceptor())
                .openSession();) {
            session.beginTransaction();
            Person p = new Person();
            p.setGender("female");
            p.setName("Sharmila");
            logger.info("saved successfully");
            session.persist(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Session session2 = HibernateUtil.getfactory()
                .withOptions()
                .interceptor(new LoggerInterceptor())
                .openSession()) {
            Person person = session2.byId(Person.class).load(1);
            System.out.println(person);
        } catch (Exception e) {
            logger.error("Failed to fetch Record:" + e);
            throw e;
        }
    }
}
