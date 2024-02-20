package cgg.tutorial.dao.impl;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.dao.EmployeeDAO;
import cgg.tutorial.entities.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public void addEmployee(Employee employee) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
         }

    @Override
    public Employee fetchEmployeeByID(int empId) {
        Session session=HibernateUtil.getfactory().openSession();
        Employee emp=session.get(Employee.class, empId);
        if(emp!=null)
        return emp;
        else
       return null;
       
        }

    @Override
    public void updateEmployee(int empId, Double newSal) {
    try (Session session=HibernateUtil.getfactory().openSession()) {
        Employee emp=session.get(Employee.class, empId);
        if(emp!=null){
            emp.setSalary(newSal);
            session.beginTransaction();
            session.merge(emp);
            session.getTransaction().commit();
        }
       
        else
        System.out.println("Does not exist");
    } catch (Exception e) {
       e.printStackTrace();
    } 
    }

    @Override
    public void deleteEmployee(int empId) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            Employee emp=session.get(Employee.class, empId);
        if(emp!=null){
            session.beginTransaction();
            session.remove(emp);
            session.getTransaction().commit();
        }
        
        else
        System.out.println("Does not exist");
        } catch (Exception e) {
            // TODO: handle exception
        }
        }
    
}
