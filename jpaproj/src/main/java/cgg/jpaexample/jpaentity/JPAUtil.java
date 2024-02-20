package cgg.jpaexample.jpaentity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    public static final String PERSISTENCE_UNIT_NAME="PERSISTENCE";
    private static EntityManagerFactory entityManagerFactory;
    public static EntityManagerFactory gEntityManagerFactory(){
        if(entityManagerFactory==null){
            entityManagerFactory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }
}
