module Paint.Paint {
    requires javafx.controls;
    requires javafx.fxml;
    exports Paint;
    opens Paint to javafx.fxml;
}