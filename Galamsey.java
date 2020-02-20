/**
 * @author Emmanuel Kebede Martey
 * @author Robert-Williams Evans
 * @author Kofi Omari Asante
 * @author Perrin Nii Obodai Provencal
 * @version 1.0.1
 */



public class Galamsey extends Position{

   

    
    private int colorVal;
    private String year;
    private String position;
    private String VegColor;

    /**
     * Default constructor to create instances
     */

    public Galamsey() {
        // TODO default constructor
    }

    /**
     * Overloaded constructor with parameters
     * @param colour
     * @param position
     * @param colorVal
     * @param year
     */

    public Galamsey(String colour,String position, int colorVal, String year) {
        this.VegColor = colour;
        this.colorVal = colorVal;
        this.position =position;
        this.year = year;
    }


    /**
     * 
     * @return VegColor
     */
   
    public String getVegColor() {
        return VegColor;
    }

    /**
     * 
     * @param VegColor
     */

    public void setVegColor(String VegColor) {
        this.VegColor = VegColor;
    }

    /**
     * 
     * @return colorVal
     */

    public int getColorVal() {
        return colorVal;
    }

    /**
     * 
     * @param colorVal
     */

    public void setColorVal(int colorVal) {
        this.colorVal = colorVal;
    }

    /**
     * 
     * @return year
     */

    public String getYear() {
        return year;
    }

    /**
     * 
     * @return position
     */

    public String getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     */

    public void setPosition(String position) {
       this.position = position;
    }

    /**
     * 
     * @param year
     */

    public void setYear(String year) {
        this.year = year;
    }

    /**
     * This returns information about the object Galamsey
     * @return print
     */

    public String printInfo(){
        String print = "Vegetation Color: " + this.getVegColor() +
                        "Color Value: " + this.getColorVal() +
                        "Year: " + this.getYear();
      
        return print;
    }
      
    
}
