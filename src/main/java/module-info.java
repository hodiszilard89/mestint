module com.example.proba1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proba1 to javafx.fxml;
    exports com.example.proba1;

}