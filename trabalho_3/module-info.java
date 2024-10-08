module com.trabalho3 {
    requires java.net.http;
    requires com.google.gson;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.trabalho3 to javafx.fxml;
    exports com.trabalho3;
}
