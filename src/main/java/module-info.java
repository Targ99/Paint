module Paint.Paint {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
//    requires java.desktop;
    exports Paint;
    opens Paint to javafx.fxml;
}