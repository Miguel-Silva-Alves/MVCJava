package com.example.mvcdepartament.view;

import com.example.mvcdepartament.model.Department;
import com.example.mvcdepartament.persistence.DepartmentDAO;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class showDepartmentController {
    @FXML private TableView<Department> table;
    @FXML private TableColumn<Department, String> cName;
    @FXML private TableColumn<Department, Integer> cCode;
    @FXML private TableColumn<Department, String> cLocation;
    @FXML private TableColumn<Department, Integer> cPhoneExtension;
    @FXML private TableColumn<Department, Double> cBudget;

    public void fill(){
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        cLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        cPhoneExtension.setCellValueFactory(new PropertyValueFactory<>("phoneExtension"));
        cBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
        table.setItems(loadValues()); //carrega na tabela todos os itens da lista
    }

    private ObservableList<Department> loadValues(){
        ObservableList<Department> departments = FXCollections.observableArrayList();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<Department> list = departmentDAO.findAll();
        list.stream().forEach(department -> departments.add(department));
        return departments;
    }

    @FXML
    private void initialize(){
        fill();
    }
}
