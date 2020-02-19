/**
 * @author Emmanuel Kebede Martey
 * @author Robert-Williams Evans
 * @author Kofi Omari Asante
 * @author Perrin Nii Obodai Provencal
 * @version 1.0.1
 */

 
import java.util.ArrayList;



public class Observatory{
    private String name;
    private String country;
    private String year_started;
    private double area_size;
    private ArrayList<Galamsey>GalamseyEvents;

    /**
     * Default constructor to create instances
     */

    public Observatory() {
    }

    /**
     * Overloaded constructor with parameters
     * @param name
     * @param country
     * @param year_started
     * @param area_size
     */

    public Observatory(String name, String country, String year_started, double area_size) {
        this.name = name;
        this.country = country;
        this.year_started = year_started;
        this.area_size = area_size;
        this.GalamseyEvents = new ArrayList<>();
    }

    /**
     * 
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return country
     */

    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     */

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return year_started
     */

    public String getYear_started() {
        return year_started;
    }

    /**
     * 
     * @param year_started
     */

    public void setYear_started(String year_started) {
        this.year_started = year_started;
    }

    /**
     * 
     * @return area_size
     */

    public double getArea_size() {
        return area_size;
    }

    /**
     * 
     * @param area_size
     */

    public void setArea_size(double area_size) {
        this.area_size = area_size;
    }

    /**
     * 
     * @return GalamseyEvents
     */

    public ArrayList<Galamsey> getGalamseyEvents() {
        return GalamseyEvents;
    }

    /**
     * 
     * @param galamseyEvents
     */

    public void addGalamseyEvents(Galamsey galamseyEvents) {
        GalamseyEvents.add(galamseyEvents);
    }

    /**
     * 
     * @return max
     */
    

    public int max_colourvalue(){
        int max = 0;
        for (Galamsey galamsey : getGalamseyEvents())
            if (galamsey.getColorVal()>max)
                max= galamsey.getColorVal();

            return max;
                
    }

    /**
     * 
     * @return average colour value
     */

    public int average_colourvalue(){
        int sum = 0;
		int count = 0;
		for(Galamsey E:getGalamseyEvents()) {
			sum+=E.getColorVal();
			count++;
		}
		
		if (count != 0)
			return sum/count;
		else 
			return 0;
			
        
    }

    /**
     * 
     * @return large
     */

    public int getLargestGalamseyColorV() {
		int large = 0;
		for(Galamsey E:getGalamseyEvents())
			if(E.getColorVal()>large)
				large = E.getColorVal();
		return large;
    }
    
    /**
     * 
     * @param k
     */

    public void list_galamsey(int k){
        int count = 1;
        System.out.println("Event " + count);
        for(Galamsey K: getGalamseyEvents())
            if (K.getColorVal() > k)
                K.printInfo();
            k++;

        
        System.out.println();
        System.out.println("Event " + count);
    }


    /**
     * Overridden toString method for observatory
     */

    public String toString() {
		return "Name of Observatory: "+getName()+"\nCountry of Observatory: "+getCountry()+
				"\nYear started: "+getYear_started()+"\nArea covered by Observatory: "+getArea_size();
	}



}

   

