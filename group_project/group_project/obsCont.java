package group_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class obsCont {
    @FXML private Button backObs, saveObs;
    @FXML private TextField obsName, Obscountry, yearObs, obsArea;
    MonitoringsIO operation = new MonitoringsIO();

    public void back (ActionEvent actionEvent) throws IOException {
        Parent newScreen = FXMLLoader.load(getClass().getResource("group_project/Home.fxml"));
        Scene scene = new Scene(newScreen);
        Stage stage2 = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage2.setScene(scene);
        stage2.show();
    }

    public void save(ActionEvent actionEvent) throws IOException {
        Observatory nasa= new Observatory(obsName.getText(), Obscountry.getText(), yearObs.getText(),
                Double.parseDouble(obsArea.getText()));
        operation.addToDb(nasa);
        System.out.println("Success!");
        obsName.clear();
        Obscountry.clear();
        yearObs.clear();
        obsArea.clear();

    }

}
