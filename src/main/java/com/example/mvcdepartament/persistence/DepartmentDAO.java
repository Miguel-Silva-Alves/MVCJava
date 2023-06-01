package com.example.mvcdepartament.persistence;

import com.example.mvcdepartament.model.Department;
import com.example.mvcdepartament.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements BaseDAO<Department, Integer>{
    @Override
    public void save(Department item) {
        String sql = "INSERT INTO Department (code, name, location, phoneExtension, budget) values (?,?,?,?,?)";
        //Não precisa de uma instância do objeto ConnectionFactory apenas para usar um método
        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, item.getCode());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getLocation());
            stmt.setInt(4, item.getPhoneExtension());
            stmt.setDouble(5, item.getBudget());
            stmt.execute();
        }catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void update(Department item) {

    }

    @Override
    public void delete(Department item) {

    }

    @Override
    public void deleteByKey(Integer key) {

    }

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        String sql = "SELECT * from Department;";
        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                // int phoneExtention, double budget
                Department department = new Department(
                        rs.getString("name"),
                        rs.getInt("code"),
                        rs.getString("location"),
                        rs.getInt("phoneExtension"),
                        rs.getDouble("budget")
                );
                departmentList.add(department);
            }
        }catch (SQLException e){e.printStackTrace();}

        loadNestedEntitiesHook(departmentList);
        return departmentList;
    }

    @Override
    public void findOne(Integer key) {

    }

    @Override
    public void loadNestedEntitiesHook(List<Department> entities) {
        entities.stream().forEach(department -> loadEmployees(department));
    }

    public void loadEmployees(Department department){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.findByDepartament(department);
        employees.stream().forEach(employee -> department.addEmployee(employee));
    }
}
