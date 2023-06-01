package com.example.mvcdepartament;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    public void close(){
        Stage stage = (Stage) welcomeText.getScene().getWindow();
        stage.close();
    }
}