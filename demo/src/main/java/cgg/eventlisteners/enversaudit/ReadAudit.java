package cgg.eventlisteners.enversaudit;

import cgg.eventlisteners.HibernateUtil;
import cgg.eventlisteners.entities.Person;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

public class ReadAudit {

  public static void main(String[] args) {
    Session session = HibernateUtil.getfactory().openSession();
    AuditReader ad = AuditReaderFactory.get(session);
    List<Number> rev = AuditReaderFactory
      .get(session)
      .getRevisions(Person.class, 1);
    for (Number number : rev) {
      Person person = ad.find(Person.class, 1, number);
      System.out.println("REvision no: " + number);
      System.out.println(person);
    }
  }
}
