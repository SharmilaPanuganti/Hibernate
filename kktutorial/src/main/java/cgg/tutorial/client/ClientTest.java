package cgg.tutorial.client;

import java.util.Date;

import cgg.tutorial.entities.Employee;
import cgg.tutorial.model.Address;
import cgg.tutorial.service.EmployeeService;
import cgg.tutorial.service.impl.EmployeeServiceImpl;

public class ClientTest {

    public static void main(String[] args) {

        EmployeeService empService = new EmployeeServiceImpl();
        createEmployee(empService);
        // getEmployeeByID(empService);
        // HibernateUtil.closeSessionFactory();
        // updateEmployee(empService);
        // deleteEmployee(empService);

    }

    private static void deleteEmployee(EmployeeService empService) {
        empService.deleteEmployee(6);
    }

    private static void createEmployee(EmployeeService empService) {
        empService.createEmployee(getEmployee());
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmpName("Martin");
        employee.setEmail("Martin2020@gmail.com");
        employee.setSalary(800000.0);
        employee.setDoj(new Date());
        Address homeAdd = new Address();
        homeAdd.setCity("HYD");
        homeAdd.setState("TS");
        homeAdd.setPincode(500416l);
        homeAdd.setStreet("Gachibowli");
        Address ofcAdd = new Address();
        ofcAdd.setCity("DRM");
        ofcAdd.setState("TS");
        ofcAdd.setPincode(500032l);
        ofcAdd.setStreet("Ganeshnagar");
        // employee.setHome_address(homeAdd);
        // employee.getAddresslist().add(homeAdd);
        // employee.getAddresslist().add(ofcAdd);
        return employee;
    }

    // private static Employee getEmployee1(){
    // Employee employee=new Employee();
    // employee.setEmpName("Frank");
    // employee.setEmail("frank2020@gmail.com");
    // employee.setSalary(700000.0);
    // employee.setDoj(new Date());
    // return employee;
    // }
    private static Employee getEmployee2() {
        Employee employee = new Employee();
        employee.setEmpName("Shawn");
        employee.setEmail("shawn2020@gmail.com");
        employee.setSalary(900000.0);
        employee.setDoj(new Date());
        return employee;
    }

    private static void getEmployeeByID(EmployeeService empService) {
        Employee emp = empService.getEmployeeByID(1);
        System.out.println(emp);
    }

    private static void updateEmployee(EmployeeService empService) {
        empService.updateEmployee(6, 500000.00);
    }

}
