package cgg.tutorial.fetchingstrategies;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;
import java.util.Set;
import org.hibernate.Session;

public class DynamicFetchingProfile {

  public static void main(String[] args) {
    Session session = HibernateUtil.getfactory().openSession();

    session.enableFetchProfile("dept.students");
    Department student = session.get(Department.class, 2);
    if (student != null) {
      System.out.println("Department:" + student.getDept_name());
      System.out.println("Students list");
      Set<BackupStudent> students2 = student.getStudents();
      students2.forEach(System.out::println);
    }
    session.close();
  }
}
