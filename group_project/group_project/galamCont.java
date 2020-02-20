package group_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class galamCont {
    @FXML private TextField vegCol, pos, galYear;
    @FXML private Button backGal, saveGal;
    Monitoring nasa = new Monitoring();

    public void back(ActionEvent actionEvent) throws IOException {
        Parent newScreen = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(newScreen);
        Stage stage2 = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage2.setScene(scene);
        stage2.show();
    }

    public void save(ActionEvent actionEvent){
        String veg_col = vegCol.getText();
        String location = pos.getText();
        String year = galYear.getText();
        Galamsey event = new Galamsey(veg_col, location, year);
        nasa.getObservatories().get(nasa.getObservatories().size()-1).addGalamseyEvents(event);
        vegCol.clear();
        pos.clear();
        galYear.clear();
    }

}
