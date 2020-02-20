package group_project;

import javafx.scene.control.TextField;

/**
 * @author
 * @version
 */



public class Galamsey{

    //private static enum VegColor{GREEN, YELLOW, BROWN};

    private int colorVal;
    private String year;
    private String position;
    private String VegColor;

    public Galamsey() {
        // TODO default constructor

    }

    public Galamsey(String colour,String position, String year) {
        this.VegColor = colour;
        this.colorVal = setCvalue(colour);
        this.position =position;
        this.year = year;
    }



    public String getVegColor() {
        return VegColor;
    }

    /* public static void listValidColors() {
        for (VegColor p : VegColor.values()) {
            System.out.println(p);
        }
    } */

    public void setVegColor(String VegColor) {
        this.VegColor = VegColor;
    }

    public int getColorVal() {
        return colorVal;
    }

    public void setColorVal(int colorVal) {
        this.colorVal = colorVal;
    }

    public String getYear() {
        return year;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String printInfo(){
        String print = "Vegetation Color: " + this.getVegColor() +
                "Color Value: " + this.getColorVal() +
                "Year: " + this.getYear();

        return print;
    }

    public int setCvalue(String VegColor){
        if (VegColor.toLowerCase().equals("brown")) {
            colorVal = 3;
        } else if (VegColor.toLowerCase().equals("yellow")) {
            colorVal = 2;
        } else if (VegColor.toLowerCase().equals("green")) {
            colorVal = 1;
        }
        return colorVal;
    }

    public static void main(String[] args) {
        // Position pos = new Position(1.22, 12.33);
        //Galamsey gala = new Galamsey(VegColor.GREEN, 1, 2019);
        //gala.setLatitude(1.22);
        //gala.setLongitude(12.33);
        //Galamsey gala2 = new Galamsey(VegColor.GREEN, 1, 2018);
        //gala.setLatitude(2.22);
        //gala.setLongitude(11.33);

        //Galamsey g1 = new Galamsey(VegColor.YELLOW, 1, 2019);
        //gala.setLatitude(4.22);
        //gala.setLongitude(10.33);
        // System.out.println(gala.printPosition());


    }


}
