package cgg.tutorial.assignment;

import cgg.tutorial.HibernateUtil;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.Session;

public class StudentBatchProcessing {

  public static void main(String[] args) {
    try (Session session = HibernateUtil.getfactory().openSession()) {
      // Generate and persist 20 sample instances
      Scanner sc = new Scanner(System.in);

      session.beginTransaction();
      for (int i = 1; i <= 20; i++) {
        System.out.println("Enter center id:");
        int centerId = sc.nextInt();
        StudentBusPassDetails studPass = createSampleStudPass(i, centerId);
        if (studPass != null) session.persist(studPass); else {
          System.out.println("center is not present");
          return;
        }
        if (i % 5 == 0) {
          session.flush();
          session.clear();
        }
      }
      sc.close();
      session.getTransaction().commit();
      session.close();
    }
  }

  private static StudentBusPassDetails createSampleStudPass(
    int index,
    int centerId
  ) {
    Session session = HibernateUtil.getfactory().openSession();
    CentreWiseOnlineRegistered center = session.get(
      CentreWiseOnlineRegistered.class,
      centerId
    );
    System.out.println(center.getCenterId());
    if (center != null) {
      session.beginTransaction();
      center.setRegisteredStudents(center.getRegisteredStudents() + 1);
      center.setInsertedTime(new Date());
      session.merge(center);
      session.getTransaction().commit();
      return new StudentBusPassDetails(
        "BP" + index,
        1, // Sample instDistId
        2, // Sample instMandalId
        "Univ" + index,
        "Inst" + index,
        center,
        "Course" + index,
        "Year" + index,
        "AdmissionNo" + index,
        "FromPlace" + index,
        "ToPlace" + index,
        "Via" + index,
        "ResAddress" + index,
        3, // Sample studentResAddDistId
        4, // Sample studentResAddMandalId
        5, // Sample studentResAddVillageId
        123456789012345L + index, // Sample studentCellNo
        "Qualification" + index,
        "Name" + index,
        "FatherName" + index,
        new Date(), // Sample studentDateOfBirth
        987654321012345L + index, // Sample studentSSCHallTicketNumber
        "SSCBoard" + index,
        2022L + index, // Sample studentSSCPassYear
        "SSCPassType" + index,
        'M', // Sample studentGender
        "AadharNo" + index
      );
    }
    return null;
  }
}
