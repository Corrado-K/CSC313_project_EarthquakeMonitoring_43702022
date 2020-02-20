package group_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class statsCont implements Initializable {
    @FXML private TableView table;
    @FXML private TableColumn tableCol, tableColorValue, tableYear, table_pos;
    @FXML private TextField identifyObs, identifyColor;
    @FXML private Label largeAvg, largestColVal;
    @FXML private Button Display, tableEntry;
    Monitoring operations = new Monitoring();
    ObservableList<TableContent> galamseys = FXCollections.observableArrayList();

    public void display(ActionEvent actionEvent){
        largeAvg.setText(String.valueOf(operations.getLargestAverageGalamseyValue()));
        largestColVal.setText(String.valueOf(operations.largestGalamseyValueEverRecord()));
    }

    public ObservableList fillTable(){
        int limit = Integer.parseInt(identifyColor.getText());
        ArrayList<Galamsey> list = operations.getAllGalamseyActAboveValueof(limit);
        for (Galamsey i: list)
            galamseys.add(new TableContent(i.getVegColor(), i.getColorVal(), i.getPosition(), i.getYear()));

        return galamseys;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableCol.setCellValueFactory(new PropertyValueFactory<TableContent, String>("col"));
        tableColorValue.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("colVal"));
        tableYear.setCellValueFactory(new PropertyValueFactory<TableContent, String>("year"));
        table_pos.setCellValueFactory(new PropertyValueFactory<TableContent, String>("pos"));

        table.setItems(fillTable());

    }

}
