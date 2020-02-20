package group_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonitoringGUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("group_project/Home.fxml"));
        stage.setTitle("Galamsey Trapper");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
