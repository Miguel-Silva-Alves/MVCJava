package com.example.mvcdepartament.persistence;

import com.example.mvcdepartament.model.Department;
import com.example.mvcdepartament.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements BaseDAO<Employee, Integer> {
    @Override
    public void save(Employee item) {
        String sql = "INSERT INTO Employee (id, name, salary, jobTitle) values (?,?,?,?)";
        //Não precisa de uma instância do objeto ConnectionFactory apenas para usar um método
        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getName());
            stmt.setDouble(3, item.getSalary());
            stmt.setString(4, item.getJobTitle());
            stmt.execute();
        }catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void update(Employee item) {
        String sql = "UPDATE Employee SET name = ?, salary = ?, jobTitle = ?, dept = ? WHERE id = ?;";
        //Não precisa de uma instância do objeto ConnectionFactory apenas para usar um método
        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {

            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getSalary());
            stmt.setString(3, item.getJobTitle());
            if(item.getDept() == null){
                stmt.setNull(4, Types.INTEGER);
            }else{
                stmt.setInt(4, item.getDept().getCode());
            }

            stmt.setInt(5, item.getId());
            stmt.execute();
        }catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void delete(Employee item) {

    }

    @Override
    public void deleteByKey(Integer key) {

    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void findOne(Integer key) {

    }

    @Override
    public void loadNestedEntitiesHook(List<Employee> entities) {

    }

    public List<Employee> findByDepartament(Department department){
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * from Employee WHERE dept = ?;";
        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, department.getCode());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                //String name, int id, double salary, String jobTitle
                Employee employee = new Employee(
                       rs.getString("name"),
                       rs.getInt("id"),
                       rs.getDouble("salary"),
                       rs.getString("jobTitle")
                );
                employees.add(employee);
            }
        }catch (SQLException e){e.printStackTrace();}

        return employees;
    }
}
