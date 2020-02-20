package group_project;
import java.util.ArrayList;

/**
 *
 *
 */

public class Monitoring {

    private ArrayList<Observatory> observatories;

    public Monitoring(){
        observatories = new ArrayList<>();
    }


    public ArrayList<Observatory> getObservatories(){

        return observatories;
    }


    public void addObservatory(Observatory Observe) {
        observatories.add(Observe);
    }

    public String getObservatoryWithLargeAverage() {
        Observatory large = null;
        for(Observatory E:getObservatories())
            if(E.average_colourvalue()>large.average_colourvalue())
                large = E;
        return large.toString();
    }
    public double getLargestAverageGalamseyValue() {
        double large = 0.0;
        for(Observatory E:getObservatories())
            if(E.average_colourvalue()>large)
                large = E.average_colourvalue();
        return large;
    }
    public int largestGalamseyValueEverRecord() {
        int large = 0;
        for(Observatory E:getObservatories())
            if(E.getLargestGalamseyColorV()>large)
                large = E.getLargestGalamseyColorV();
        return large;
    }

    public String getAllGalamseyActAboveValueof(int value) {
        String info = "";
        for(Observatory E:getObservatories())
            if(E.average_colourvalue()>value) {
                String y =E+"\n";
                info+=y;
            }

    /*public ArrayList<Galamsey> galamRetrieve(){
                for(Observatory E:getObservatories())
                    for(Galamsey G:getGalamseyEvents())
        }
        return info;
    }*/






}

