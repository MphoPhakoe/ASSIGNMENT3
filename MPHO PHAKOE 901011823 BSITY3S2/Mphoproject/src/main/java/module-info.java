module com.example.mphoproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mphoproject to javafx.fxml;
    exports com.example.mphoproject;
}