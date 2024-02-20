package cgg.tutorial.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import cgg.tutorial.HibernateUtil;

public class HQLDemo {
  public static void main(String[] args) {
    SessionFactory factory = HibernateUtil.getfactory();
    Session session = factory.openSession();
    // get students
    /*
     * String hql="from Student";
     * System.out.println("Get all students:");
     * Query<Student> query = session.createQuery(hql,Student.class);
     * List<Student> list = query.list();
     * for (Student student : list) {
     * System.out.println(student);
     * }
     */

    // get studetn by id
    /*
     * String hql="from Student where student_id=:x";
     * Query<Student> query = session.createQuery(hql,Student.class);
     * query.setParameter("x", 1);
     * Student res = query.uniqueResult();
     * System.out.println(res);
     */

    // get all students names
    /*
     * String hql="select name from Student";
     * Query<String> query = session.createQuery(hql,String.class);
     * List<String> list = query.list();
     * for (String string : list) {
     * System.out.println(string);
     * }
     */

    // get name and id
    /*
     * String hql="select student_id,name from Student";
     * Query query = session.createQuery(hql);
     * List<Object[]> list = query.list();
     * for (Object[] objects : list) {
     * System.out.println(Arrays.toString(objects));
     * }
     */

    // insert queries
    /*
     * String hql="insert into Student(name,dob,marks) "
     * +"select name,dob,marks from BackupStudent";
     * Query query = session.createQuery(hql);
     * session.beginTransaction();
     * int res = query.executeUpdate();
     * System.out.println(res+" inserted");
     * session.getTransaction().commit();
     */

    // delete and update queries
    // update student marks
    // String hql = "update Student set marks=930.05 where student_id=1";
    /* String hql="delete from Student where student_id=101";
    Query query = session.createQuery(hql);
    session.beginTransaction();
    int res = query.executeUpdate();
    System.out.println(" rows deleted:"+res);
    session.getTransaction().commit();*/

    //join queries
    // String hql="from Student s left join FETCH s.address where s.student_id=1";
   /*  String hql="from Address a left outer join FETCH a.student where a.address_id=1";
    Query<Address> query = session.createQuery(hql,Address.class);
    Address res = query.uniqueResult();
    System.out.println(res.getStudent());*/

    //Certain fields
    /* String hql="select name,dob,a.pincode from Student s left join s.address a where s.student_id=1";
    Query<Object[]> query = session.createQuery(hql);
    List<Object[]> list = query.list();
    for (Object[] objects : list) {
      System.out.println(Arrays.toString(objects));
    } */
    
    session.close();  
  }
}
