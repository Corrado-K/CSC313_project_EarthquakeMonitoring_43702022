/**
 * @author Emmanuel Kebede Martey
 * @author Robert-Williams Evans
 * @author Kofi Omari Asante
 * @author Perrin Nii Obodai Provencal
 * @version 1.0.1
 */


import java.util.ArrayList;

public class Monitoring {

    private ArrayList<Observatory> observatories;


    
    public Monitoring(){
        observatories = new ArrayList<>();
    }


    /**
     * 
     * @return observatories
     */

    public ArrayList<Observatory> getObservatories(){
		
		return observatories;
    }

    /**
     * 
     * @param Observe
     */


    public void addObservatory(Observatory Observe) {
		observatories.add(Observe);
    }
    
    /**
     * 
     * @return large.toString()
     */

    public String getObservatoryWithLargeAverage() {
		Observatory large = null;
		for(Observatory E:getObservatories())
			if(E.average_colourvalue()>large.average_colourvalue())
				large = E;
		return large.toString();
    }
    
    /**
     * 
     * @return large
     */


	public double getLargestAverageGalamseyValue() {
		double large = 0.0;
		for(Observatory E:getObservatories())
			if(E.average_colourvalue()>large)
				large = E.average_colourvalue();
		return large;
    }
    
    /**
     * 
     * @return large
     */

	public int largestGalamseyValueEverRecord() {
		int large = 0;
		for(Observatory E:getObservatories())
			if(E.getLargestGalamseyColorV()>large)
				large = E.getLargestGalamseyColorV();
		return large;
    }
    
    /**
     * 
     * @param value
     * @return info
     */
	
	public String getAllGalamseyActAboveValueof(int value) {
		String info = "";
		for(Observatory E:getObservatories())
			if(E.average_colourvalue()>value) {
				String y =E+"\n";
				info+=y;
			}
		return info;
	}


}

















