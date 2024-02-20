package cgg.eventlisteners.lockings;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class EventListenerIntegrator implements Integrator {

  @Override
  public void disintegrate(
    SessionFactoryImplementor sessionFactory,
    SessionFactoryServiceRegistry serviceRegistry
  ) {}

  @Override
  public void integrate(
    Metadata metadata,
    SessionFactoryImplementor sessionFactory,
    SessionFactoryServiceRegistry serviceRegistry
  ) {
    EventListenerRegistry service = serviceRegistry.getService(
      EventListenerRegistry.class
    );
    System.out.println("Event listener called");
    service
      .getEventListenerGroup(EventType.PERSIST)
      .appendListener(new PersistEventListenerEx());
    service
      .getEventListenerGroup(EventType.SAVE_UPDATE)
      .appendListener(new SaveOrUpdateListenerEx());
    service
      .getEventListenerGroup(EventType.MERGE)
      .appendListener(new MergeEventListenerEx());
    service
      .getEventListenerGroup(EventType.REFRESH)
      .appendListener(new RefreshEventListenerEx());
  }
}
