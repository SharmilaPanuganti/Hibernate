package cgg.jpaexample.jpaentity;

import java.util.Date;

import jakarta.persistence.EntityManager;

public class PersitenceEntityJPA {
    public static void main(String[] args) {
        EntityManager entityManager = null;
        try {
            JPAStudent st = new JPAStudent();
            st.setDob(new Date());
            st.setMarks(900.87);
            st.setName("Sharmila");
            entityManager = JPAUtil.gEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(st);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }
}
