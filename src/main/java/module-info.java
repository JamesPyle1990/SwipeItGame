module com.example.swipegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.swipegame to javafx.fxml;
    exports com.example.swipegame;
}