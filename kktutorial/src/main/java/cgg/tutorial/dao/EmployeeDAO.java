package cgg.tutorial.dao;

import cgg.tutorial.entities.Employee;

public interface EmployeeDAO {
    public abstract void addEmployee(Employee employee);
    public abstract Employee fetchEmployeeByID(int empId);
    public abstract void updateEmployee(int empId,Double newSal);
    public abstract void deleteEmployee(int empId);
}
