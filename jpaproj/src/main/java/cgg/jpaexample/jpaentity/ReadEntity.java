package cgg.jpaexample.jpaentity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;

import jakarta.persistence.EntityManager;

public class ReadEntity {
    public static void main(String[] args) {
        Session session = null;
        try {
            EntityManager entityManager = JPAUtil.gEntityManagerFactory().createEntityManager();
            // SessionImplementor session = entityManager.unwrap(SessionImplementor.class);
            SessionFactory factory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
            session = factory.openSession();
            JPAStudent jpaStudent = session.get(JPAStudent.class, 1);
            System.out.println(jpaStudent.getName());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

    }
}
