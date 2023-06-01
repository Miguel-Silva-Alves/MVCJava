package com.example.mvcdepartament.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Department {
    private String name;
    private int code;
    private String location;

    private int phoneExtension;

    private double budget;

    private List<Employee> employs;

    public Department(String name, int code, String location, int phoneExtension, double budget) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.phoneExtension = phoneExtension;
        this.budget = budget;
        this.employs = new ArrayList<>();
    }

    // methods
    public void addEmployee(Employee employee){
        employs.add(employee);
    }

    public void removeEmployee(Employee employee){
        if(employs.contains(employee)){
            employs.remove(employee);
        }
    }

    public void removeEmployee(int id){
        Optional<Employee> optional = employs.stream().filter(employee -> employee.getId() == id).findFirst();
        if(optional.isPresent()){
            employs.remove(optional.get());
        }
    }

    public void listAllEmployees(){
        employs.stream().forEach(employee -> System.out.println(employee));
    }

    public int sizeOfEmployees(){
        return employs.size();
    }

    public Employee getEmployee(int id){
        Optional<Employee> optional = employs.stream().filter(employee -> employee.getId() == id).findFirst();
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }




    // gets
    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getLocation() {
        return location;
    }

    public int getPhoneExtension() {
        return phoneExtension;
    }

    public double getBudget() {
        return budget;
    }

    // to string

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", location='" + location + '\'' +
                ", phoneExtention=" + phoneExtension +
                ", budget=" + budget +
                '}';
    }
}
