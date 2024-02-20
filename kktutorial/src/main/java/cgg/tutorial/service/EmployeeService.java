package cgg.tutorial.service;

import cgg.tutorial.entities.Employee;

public interface EmployeeService {
    public abstract void createEmployee(Employee employee);
    public abstract Employee getEmployeeByID(int empId);
    public abstract void updateEmployee(int empId,Double newSal);
    public abstract void deleteEmployee(int empId);
}
