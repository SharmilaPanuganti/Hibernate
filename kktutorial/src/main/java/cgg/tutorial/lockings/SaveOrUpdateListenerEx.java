package cgg.tutorial.lockings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

public class SaveOrUpdateListenerEx implements SaveOrUpdateEventListener {
    private static final Logger logger = LogManager.getLogger(SaveOrUpdateListenerEx.class);

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
        logger.info("SAveor update is called");
        throw new UnsupportedOperationException("Unimplemented method 'onSaveOrUpdate'");
    }

}
