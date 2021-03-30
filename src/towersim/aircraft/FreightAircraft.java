package towersim.aircraft;

import towersim.tasks.*;

/**
 * Freight aircraft extending Aircraft
 *
 * @author tli14
 */
public class FreightAircraft extends Aircraft {

    /**
     * freight currently in aircraft in kg
     */
    private int freightAmount;

    /**
     * Constructor for new Freight aircraft
     *
     * @param callsign        unique callsign
     * @param characteristics characteristics that describe this aircraft
     * @param tasks           task list to be used by aircraft
     * @param fuelAmount      current amount of fuel onboard, in litres
     * @param freightAmount   current amount of freight onboard, in kilograms
     * @throws IllegalArgumentException if freightAmount < 0 or if freightAmount > freight capacity
     */
    public FreightAircraft(String callsign, AircraftCharacteristics characteristics,
                           TaskList tasks, double fuelAmount, int freightAmount) {
        super(callsign, characteristics, tasks, fuelAmount);
        if (freightAmount < 0 || freightAmount > this.getCharacteristics().freightCapacity) {
            throw new IllegalArgumentException();
        }

        this.freightAmount = freightAmount;
    }

    /**
     * Calculates the percentage level of load of the aircraft
     *
     * @return 100% * (load / capacity) rounded to nearest integer
     */
    public int calculateOccupancyLevel() {
        return (int) Math.round((freightAmount / this.getCharacteristics().freightCapacity) * 100);
    }

    /**
     * Returns the number of ticks required to load the aircraft at the gate.
     *
     * @return loadingTime
     * The loading time for freight aircraft is given by the following table:
     * <p>
     * Freight to be loaded (kg)|Loading time (ticks)
     * <1000|1
     * 1000 to 50,000|2
     * >50,000|3
     * @specifiedBy Aircraft.getLoadingTime
     */
    public int getLoadingTime() {
        //returns number of ticks for freight load,
        // <1000:1, 1000<50000:2, 50000<:3
        //overwrites abstract method in aircraft
        int loadAmount = getTaskList().getCurrentTask().getLoadPercent() *
                getCharacteristics().freightCapacity / 100;
        if (loadAmount == 0) {
            return 0;
        } else if (loadAmount < 1000) {
            return 1;
        } else if (loadAmount > 50000) {
            return 3;
        } else {
            return 2;
        }
    }

    /**
     * Returns the total weight of the aircraft in its current state.
     *
     * @return totalWeight sum of fuelWeight, aircraftWeight and freightAmount
     * @overrides Aircraft.getTotalWeight
     */
    public double getTotalWeight() {
        double fuelWeight = getFuelAmount() * LITRE_OF_FUEL_WEIGHT;
        double aircraftWeight = this.getCharacteristics().emptyWeight;

        double noFreightWeight = fuelWeight + aircraftWeight;
        return noFreightWeight + freightAmount;
    }

    /**
     * Updates the aircraft's state on each tick of the simulation.
     *
     * @overrides Aircraft.tick
     * @SpecifiedBy Tickable.tick
     * freight is loading onto aircraft at a speed of loadPercentage * capacity / loadtime
     * freight amount will be set to loadPercentage * capacity if the load exceeds it
     */
    public void tick() {
        //placeholder
        super.tick();
        if (this.getTaskList().getCurrentTask().getType() == TaskType.LOAD) {
            int loadTarget = (int) Math.round(this.getCharacteristics().freightCapacity *
                    getTaskList().getCurrentTask().getLoadPercent() / 100.0);
            int loadPerTick = loadTarget / this.getLoadingTime();
            this.freightAmount = freightAmount + loadPerTick;
            if (freightAmount > loadTarget) {
                freightAmount = loadTarget;
            }
        }
    }
}
