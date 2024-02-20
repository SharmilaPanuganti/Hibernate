package cgg.jpaexample.jpaentity;

import java.util.Date;

import org.hibernate.Session;

import jakarta.persistence.EntityManager;

public class PersistenEntityHibernate {
    public static void main(String[] args) {
        EntityManager entityManager = null;
        Session session = null;
        try {
            JPAStudent st = new JPAStudent();
            st.setDob(new Date());
            st.setMarks(920.87);
            st.setName("Sharmila Panuganti");
            entityManager = JPAUtil.gEntityManagerFactory().createEntityManager();
            session = entityManager.unwrap(Session.class);
            session.getTransaction().begin();
            session.persist(st);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null)
                entityManager.close();

        }
    }
}
