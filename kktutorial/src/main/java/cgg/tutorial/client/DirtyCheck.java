package cgg.tutorial.client;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.entities.Employee;

public class DirtyCheck {
    public static void main(String[] args) {
        Session session=null;
        try{
            session=HibernateUtil.getfactory().openSession();
          Employee employee = session.get(Employee.class, 1);
          if(employee!=null){
            session.beginTransaction();
            employee.setSalary(700000);
            session.merge(employee);
            session.getTransaction().commit();

          }
          else{
            System.out.println("does not exist");
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(session!=null)
            session.close();
        }
    }
}
