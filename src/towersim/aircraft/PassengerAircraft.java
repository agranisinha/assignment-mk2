package towersim.aircraft;

import towersim.tasks.*;

/**
 * Passenger aircraft class extending aircraft
 *
 * @author tli14
 */
public class PassengerAircraft extends Aircraft {
    /**
     * Average weight of a single passenger including their baggage, in kilograms.
     */
    public static final double AVG_PASSENGER_WEIGHT = 90;
    /**
     * number of passengers currently on aircraft
     */
    private int passengerCount;

    /**
     * Constructor for new passenger aircraft
     *
     * @param callsign        unique callsign
     * @param characteristics characteristics that describe this aircraft
     * @param tasks           task list to be used by aircraft
     * @param fuelAmount      current amount of fuel onboard, in litres
     * @param numPassengers   current number of passengers onboard
     * @throws IllegalArgumentException if numPassengers < 0 or if numPassengers >
     *                                  passenger capacity
     */
    public PassengerAircraft(String callsign, AircraftCharacteristics characteristics,
                             TaskList tasks, double fuelAmount, int numPassengers) {
        super(callsign, characteristics, tasks, fuelAmount);
        if (numPassengers < 0 || numPassengers > characteristics.passengerCapacity) {
            throw new IllegalArgumentException();
        }
        this.passengerCount = numPassengers;
    }

    /**
     * Returns the ratio of passengers onboard to maximum passenger capacity as a
     * percentage between 0 and 100.
     *
     * @return occupancy level as a percentage
     */
    public int calculateOccupancyLevel() {
        return (int) Math.round((double) passengerCount / this.getCharacteristics()
                .passengerCapacity * 100);
    }

    /**
     * Returns the number of ticks required to load the aircraft at the gate.
     *
     * @return loadingTicks
     */
    public int getLoadingTime() {
        //placeholder, do after completing tasks
        int passengerToBeLoaded = (int) ((double) this.getTaskList().getCurrentTask()
                .getLoadPercent() * this.getCharacteristics().passengerCapacity) / 100;
        int loadingTicks = (int) Math.round(Math.log10(passengerToBeLoaded));
        return loadingTicks;
    }

    /**
     * Returns the total weight of the aircraft in its current state.
     *
     * @return totalWeight
     */
    public double getTotalWeight() {
        double fuelWeight = getFuelAmount() * LITRE_OF_FUEL_WEIGHT;
        double aircraftWeight = this.getCharacteristics().emptyWeight;
        return fuelWeight + aircraftWeight + passengerCount * AVG_PASSENGER_WEIGHT;
        //returns aircraft weight + passenger weight
    }

    /**
     * Updates the aircraft's state on each tick of the simulation.
     * <p>
     * modifies passengerCount as per loading within loadTarget
     */
    public void tick() {
        super.tick();
        if (getTaskList().getCurrentTask().getType() == TaskType.LOAD) {
            int loadTarget = (int) Math.round(this.getCharacteristics().passengerCapacity
                    * getTaskList().getCurrentTask().getLoadPercent() / 100.0);
            int loadPerTick = (int) Math.round(1.0 * loadTarget / this.getLoadingTime());
            System.out.println(loadPerTick);
            this.passengerCount = passengerCount + loadPerTick;
            if (passengerCount > loadTarget) {
                passengerCount = loadTarget;
            }
        }
    }


}
