package com.example.mvcdepartament.controller;

import com.example.mvcdepartament.persistence.DepartmentDAO;
import com.example.mvcdepartament.model.Department;
import com.example.mvcdepartament.model.Employee;

public class DepartmentSerice {
    private DepartmentDAO dao;

    public DepartmentSerice(DepartmentDAO dao) {
        this.dao = dao;
    }
    public void addEmployee(Department department, Employee employee){
        employee.setDept(department);

    }
}
