package towersim.aircraft;

import towersim.tasks.*;

public class FreightAircraft extends Aircraft {

    private int freightAmount;
    //freight amount in kg

    public FreightAircraft(String callsign, AircraftCharacteristics characteristics,
                           TaskList tasks, double fuelAmount, int freightAmount) {
        super(callsign, characteristics, tasks, fuelAmount);
        this.freightAmount = freightAmount;
    }

    public int calculateOccupancyLevel() {
        return (int) Math.round((freightAmount / this.getCharacteristics().freightCapacity) * 100);
    }
    //returns the percentage of freight weight used

    public int getLoadingTime() {
        //returns number of ticks for freight load,
        // <1000:1, 1000<50000:2, 50000<:3
        //overwrites abstract method in aircraft
        int loadAmount = (int) (getTaskList().getCurrentTask().getLoadPercent()/100)*getCharacteristics().freightCapacity;
        if (loadAmount < 1000) {
            return 1;
        } else if (loadAmount > 50000) {
            return 3;
        } else {
            return 2;
        }
    }

    public double getTotalWeight() {
        double fuelWeight = getFuelAmount() * LITRE_OF_FUEL_WEIGHT;
        double aircraftWeight = this.getCharacteristics().emptyWeight;

        double noFreightWeight = fuelWeight + aircraftWeight;
        return noFreightWeight + freightAmount;
    }

    public void tick() {
        //placeholder
    }
}
