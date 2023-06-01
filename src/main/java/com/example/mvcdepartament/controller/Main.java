package com.example.mvcdepartament.controller;

import com.example.mvcdepartament.persistence.DepartmentDAO;
import com.example.mvcdepartament.persistence.EmployeeDAO;
import com.example.mvcdepartament.model.Department;
import com.example.mvcdepartament.model.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Employee employee = new Employee("Miguel", 1, 2500,"Dev");
//        EmployeeDAO employeeDAO = new EmployeeDAO();


        DepartmentDAO departmentDAO = new DepartmentDAO();
//        Department department = new Department("Desenvolvimento", 1, "Av. São Carlos", 16, 1000);
//        //department.addEmployee(employee);
//
//        employeeDAO.update(employee);
        //departmentDAO.save(department);
        List<Department> list = departmentDAO.findAll();
        list.stream().forEach(department -> System.out.println(department));
    }

}
