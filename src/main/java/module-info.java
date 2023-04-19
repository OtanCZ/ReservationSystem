module otan.tos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens otan.tos to javafx.fxml;
    exports otan.tos;
}