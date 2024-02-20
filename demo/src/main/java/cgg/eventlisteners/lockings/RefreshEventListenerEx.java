package cgg.eventlisteners.lockings;

import cgg.eventlisteners.entities.Person;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.RefreshContext;
import org.hibernate.event.spi.RefreshEvent;
import org.hibernate.event.spi.RefreshEventListener;

public class RefreshEventListenerEx implements RefreshEventListener {

  private static final long serialVersionUID = 1L;
  private static Logger logger = LogManager.getLogger(
    RefreshEventListenerEx.class
  );

  @Override
  public void onRefresh(RefreshEvent e) throws HibernateException {
    logger.info("onRefresh is called.");
    Object obj = e.getObject();
    if (obj instanceof Person) {
      Person person = (Person) obj;
      logger.info(person);
    }
  }

  @Override
  public void onRefresh(RefreshEvent event, RefreshContext refreshedAlready)
    throws HibernateException {
    // TODO Auto-generated method stub
    logger.info("refresh called");
  }
}
