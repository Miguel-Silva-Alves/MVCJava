package com.example.mvcdepartament.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DepartmentController {

    @FXML
    Button btnChangeView;

    @FXML
    public void changeView(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("showDepartments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
