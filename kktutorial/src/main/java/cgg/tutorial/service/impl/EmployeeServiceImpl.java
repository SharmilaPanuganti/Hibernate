package cgg.tutorial.service.impl;

import cgg.tutorial.dao.impl.EmployeeDAOImpl;
import cgg.tutorial.entities.Employee;
import cgg.tutorial.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public void createEmployee(Employee employee) {
        new EmployeeDAOImpl().addEmployee(employee);
    }

    @Override
    public Employee getEmployeeByID(int empId) {
        return new EmployeeDAOImpl().fetchEmployeeByID(empId);
          }

    @Override
    public void updateEmployee(int empId, Double newSal) {
        new EmployeeDAOImpl().updateEmployee(empId, newSal);
    }
       

    @Override
    public void deleteEmployee(int empId) {
        new EmployeeDAOImpl().deleteEmployee(empId);
          }
    
}
