package cgg.eventlisteners.lockings;

import cgg.eventlisteners.entities.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.MergeContext;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;

public class MergeEventListenerEx implements MergeEventListener {

  private static final Logger logger = LogManager.getLogger(
    MergeEventListenerEx.class
  );

  @Override
  public void onMerge(MergeEvent event) throws HibernateException {
    logger.info("Merge is called");
    Object ob = event.getEntity();
    if (ob instanceof Person) {
      Person p = (Person) ob;
      logger.info(p);
    }
  }

  @Override
  public void onMerge(MergeEvent event, MergeContext copiedAlready)
    throws HibernateException {
    logger.info("Merge called");
  }
}
