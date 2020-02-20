package group_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class statsTableCont implements Initializable {
    @FXML private TableView table;
    @FXML TableColumn ObsTableVegColor, ObsTableColVal, ObsTablePosition, ObsTableYear;
    @FXML Button submit;
    @FXML TextField obsName;
    ObservableList<TableContent> galamseys = FXCollections.observableArrayList();
    Monitoring nasa = new Monitoring();

    public void display(ActionEvent actionEvent){
        ArrayList<Galamsey> allgalam = nasa.galamRetrieve(obsName.getText());
        for (Galamsey i : allgalam)
            galamseys.add(new TableContent(i.getVegColor(), i.getColorVal(), i.getPosition(), i.getYear()));

        return galamseys;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObsTableVegColor.setCellValueFactory(new PropertyValueFactory<TableContent, String>("col"));
        ObsTableColVal.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("colVal"));
        ObsTablePosition.setCellValueFactory(new PropertyValueFactory<TableContent, String>("pos"));
        ObsTableYear.setCellValueFactory(new PropertyValueFactory<TableContent, String>("year"));

        table.setItems(display());
    }
}
