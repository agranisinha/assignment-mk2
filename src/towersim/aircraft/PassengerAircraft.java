package towersim.aircraft;

import towersim.tasks.*;


public class PassengerAircraft extends Aircraft {
    public static final double AVG_PASSENGER_WEIGHT = 90;
    private int passengerCount;

    public PassengerAircraft(String callsign, AircraftCharacteristics characteristics, TaskList tasks, double fuelAmount, int numPassengers) {
        super(callsign, characteristics, tasks, fuelAmount);

        this.passengerCount = numPassengers;
    }

    public int calculateOccupancyLevel() {
        return (int) passengerCount / this.getCharacteristics().passengerCapacity * 100;
    }

    public int getLoadingTime() {
        //placeholder, do after completing tasks
        return 0;
    }

    public double getTotalWeight() {
        double fuelWeight = getFuelAmount() * LITRE_OF_FUEL_WEIGHT;
        double aircraftWeight = this.getCharacteristics().emptyWeight;
        return fuelWeight + aircraftWeight + passengerCount * AVG_PASSENGER_WEIGHT;
        //returns aircraft weight + passenger weight
    }

    public void tick() {
        //placeholder
    }


}
