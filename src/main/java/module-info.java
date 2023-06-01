module com.example.mvcdepartament {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.mvcdepartament.model to javafx.base;
            
                            
    opens com.example.mvcdepartament to javafx.fxml;
    exports com.example.mvcdepartament;
    exports com.example.mvcdepartament.controller;
    opens com.example.mvcdepartament.controller to javafx.fxml;
    exports com.example.mvcdepartament.view;
    opens com.example.mvcdepartament.view to javafx.fxml;
}