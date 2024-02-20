package cgg.tutorial.lockings;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;

import cgg.tutorial.inheritance.Person;

public class LoggerInterceptor implements Interceptor {

    private static final long serialVID = 1L;
    private static Logger logger = LogManager.getLogger(LoggerInterceptor.class);

    @Override
    public boolean onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        logger.info("save method is called");
        if (entity instanceof Person) {
            Person person = (Person) entity;
            logger.info(person);
        }
        return Interceptor.super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        logger.info("load method is called");
        if (entity instanceof Person) {
            Person person = (Person) entity;
            logger.info(person);
        }
        return Interceptor.super.onLoad(entity, id, state, propertyNames, types);
    }

}
