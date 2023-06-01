package com.example.mvcdepartament.model;

import java.util.Objects;

public class Employee {
    private String name;
    private int id;
    private double salary;
    private String jobTitle;

    private Department dept;

    public Employee(String name, int id, double salary, String jobTitle) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(dept, employee.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, salary, jobTitle, dept);
    }

    public void getAnnualSalary(){
        System.out.println("R$"+ this.salary * 12);
    }

    public void setDept(Department dept){
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Department getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", jobTitle='" + jobTitle + '\'' +
                ", dept=" + dept +
                '}';
    }
}
