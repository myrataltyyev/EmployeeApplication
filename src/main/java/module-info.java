module com.example.testapplicationjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires lombok;
    requires org.slf4j;
    requires javafx.graphics;
    requires java.sql;
    requires dotenv.java;

    opens com.example.testapplicationjava to javafx.fxml;
    opens com.example.testapplicationjava.model to javafx.base;
    exports com.example.testapplicationjava;
}