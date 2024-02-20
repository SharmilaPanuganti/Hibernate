package cgg.tutorial.lockings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.PersistContext;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;

import cgg.tutorial.inheritance.Person;

public class PersistEventListenerEx implements PersistEventListener {
    private static final Logger logger = LogManager.getLogger(PersistEventListenerEx.class);

    @Override
    public void onPersist(PersistEvent event) throws HibernateException {
        System.out.println("Persist is called");
        logger.info("Persist is called");
        Object ob = event.getObject();
        if (ob instanceof Person) {
            Person p = (Person) ob;
            logger.info(p);
        }
    }

    @Override
    public void onPersist(PersistEvent event, PersistContext createdAlready) throws HibernateException {

    }

}
