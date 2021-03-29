package towersim.aircraft;

import towersim.tasks.*;


public class PassengerAircraft extends Aircraft {
    public static final double AVG_PASSENGER_WEIGHT = 90;
    private int passengerCount;

    public PassengerAircraft(String callsign, AircraftCharacteristics characteristics,
                             TaskList tasks, double fuelAmount, int numPassengers) {
        super(callsign, characteristics, tasks, fuelAmount);

        this.passengerCount = numPassengers;
    }

    public int calculateOccupancyLevel() {
        return (int) Math.round(passengerCount / this.getCharacteristics().passengerCapacity * 100);
    }

    public int getLoadingTime() {
        //placeholder, do after completing tasks
        int passengerToBeLoaded = (int) ((double) this.getTaskList().getCurrentTask().getLoadPercent() *
                this.getCharacteristics().passengerCapacity) / 100;
        int loadingTicks = (int) Math.round(Math.log10(passengerToBeLoaded));
        return loadingTicks;
    }

    public double getTotalWeight() {
        double fuelWeight = getFuelAmount() * LITRE_OF_FUEL_WEIGHT;
        double aircraftWeight = this.getCharacteristics().emptyWeight;
        return fuelWeight + aircraftWeight + passengerCount * AVG_PASSENGER_WEIGHT;
        //returns aircraft weight + passenger weight
    }

    public void tick() {
        super.tick();
        if (getTaskList().getCurrentTask().getType() == TaskType.LOAD) {
            int loadTarget = (int) Math.round(this.getCharacteristics().passengerCapacity * getTaskList().getCurrentTask().getLoadPercent() / 100.0);
            int loadPerTick = (int) Math.round(1.0 * loadTarget / this.getLoadingTime());
            this.passengerCount = passengerCount + loadPerTick;
            if (passengerCount > loadTarget) {
                passengerCount = loadTarget;
            }
        }
    }


}
