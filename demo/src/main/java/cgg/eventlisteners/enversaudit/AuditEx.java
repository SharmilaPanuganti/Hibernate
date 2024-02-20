package cgg.eventlisteners.enversaudit;

import cgg.eventlisteners.HibernateUtil;
import cgg.eventlisteners.entities.Person;
import org.hibernate.Session;

public class AuditEx {

  public static void main(String[] args) {
    try (Session session = HibernateUtil.getfactory().openSession();) {
      session.beginTransaction();
      Person p = new Person();
      p.setGender("male");
      p.setName("sss");
      Person p2 = new Person();
      p2.setGender("female");
      p2.setName("Sharmi");
      // logger.info(" saved");
      // session.saveOrUpdate(p);
      session.persist(p);
      session.persist(p2);
      session.getTransaction().commit();
      session.close();
      Session session2 = HibernateUtil.getfactory().openSession();
      Person person1 = session2.get(Person.class, 1);
      if (person1 != null) {
        session2.beginTransaction();
        person1.setGender("female");

        session2.merge(person1);
        session2.getTransaction().commit();
      }
      session2.close();
      Session session3 = HibernateUtil.getfactory().openSession();
      Person person2 = session3.get(Person.class, 2);
      if (person2 != null) {
        session3.beginTransaction();

        session3.remove(person2);
        session3.getTransaction().commit();
      }
      session3.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
