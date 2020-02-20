package group_project;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableContent {
    //Galamsey variables to populate table
    SimpleStringProperty col, year, pos;
    SimpleIntegerProperty colVal;


    //Galamsey
    TableContent(String vegCol, int colVal, String pos, String year){
        col = new SimpleStringProperty(vegCol);
        this.colVal = new SimpleIntegerProperty(colVal);
        this.pos = new SimpleStringProperty(pos);
        this.year = new SimpleStringProperty(year);
    }

    public String getCol() {
        return col.get();
    }

    public SimpleStringProperty colProperty() {
        return col;
    }

    public void setCol(String col) {
        this.col.set(col);
    }

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getPos() {
        return pos.get();
    }

    public SimpleStringProperty posProperty() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos.set(pos);
    }

    public int getColVal() {
        return colVal.get();
    }

    public SimpleIntegerProperty colValProperty() {
        return colVal;
    }

    public void setColVal(int colVal) {
        this.colVal.set(colVal);
    }


}
