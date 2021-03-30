package towersim.aircraft;

import towersim.util.*;
import towersim.tasks.*;

/**
 * Mother class of all aircraft types
 */
public abstract class Aircraft implements EmergencyState, OccupancyLevel, Tickable {
    /**
     * Weight of a litre of aviation fuel, in kilograms.
     */
    public static final double LITRE_OF_FUEL_WEIGHT = 0.8;

    /**
     * the state of emergency of the aircraft
     */
    private boolean emergencyState;

    /**
     * Callsign of the aircraft
     */
    private String callSign;

    /**
     * custom object including name, type, weight, fuel capacity
     * passenger capacity, and freight capacity in an enum
     */
    private AircraftCharacteristics characteristics;

    /**
     *custom object list of tasks
     */
    private TaskList listOfTasks;

    /**
     * fuel amount in Litres
     */
    private double fuelAmount;

    /**
     * Constructor
     *
     * @param callsign        callsign of aircraft
     * @param characteristics characteristics that describe this aircraft
     * @param tasks           task list to be used by aircraft
     * @param fuelAmount      current fuel amount of the aircraft in litres
     * @exception IllegalArgumentException if fuelAmount < 0 or if fuelAmount > fuel capacity
     */
    protected Aircraft(String callsign, AircraftCharacteristics characteristics,
                       TaskList tasks, double fuelAmount) {
        if(fuelAmount < 0 || fuelAmount > characteristics.fuelCapacity){
            throw new IllegalArgumentException();
        }
        this.callSign = callsign;
        this.characteristics = characteristics;
        this.listOfTasks = tasks;
        this.emergencyState = false;
        this.fuelAmount = fuelAmount;
        //constructs the object
    }

    /**
     * Declares a state of emergency.
     */
    public void declareEmergency() {
        emergencyState = true;
    }

    /**
     * Clears any active state of emergency.
     */
    public void clearEmergency() {
        emergencyState = false;
    }

    /**
     * retrieves state of emergency of the aircraft
     * @return emergencyState
     */
    public boolean hasEmergency() {
        return emergencyState;
    }
    //emergency state functions, overriding emergency state interface.


    //getters

    /**
     *retrieves aircraft callsign
     * @return callSign
     */
    public String getCallsign() {
        return callSign;
    }

    /**
     * Retrieves aircraft characteristics
     * @return characteristics
     */
    public AircraftCharacteristics getCharacteristics() {
        return characteristics;
    }

    /**
     * Retrieves the current fuel amount held by aircraft in Litres
     * @return fuelAmount
     */
    public double getFuelAmount() {
        return fuelAmount;
    }

    /**
     * Returns the percentage value of fuel remaining for this aircraft
     * @return fuelPercentage
     */
    public int getFuelPercentRemaining() {
        //get fuel capacity from characteristics and divide the fuel amount by it then*100
        return (int) (fuelAmount / this.characteristics.fuelCapacity * 100);
    }

    /**
     * retrieves loading time in subclass
     * @return loadingTime
     */
    public abstract int getLoadingTime();

    /**
     * Retrieves the tasklist of this aircraft
     * @return listOfTasks
     */
    public TaskList getTaskList() {
        return listOfTasks;
    }

    /**
     * Return total weight of the aircraft including fuel, and aircraft weight, ignoring load
     * @return weight such weight = fuelWeight + aircraftWeight
     */
    public double getTotalWeight() {
        double fuelWeight = fuelAmount * LITRE_OF_FUEL_WEIGHT;
        double aircraftWeight = this.characteristics.emptyWeight;
        return fuelWeight + aircraftWeight;
        //get fuel weight and plane weight and return SUM
    }
    //getters

    /**
     * Updates the aircraft's state on each tick of the simulation.
     *
     * Aircraft lose 10% of total fuel capacity or until empty each tick if current task is away
     *
     * If the aircraft's current task is LOAD,
     * the amount of fuel should increase by capacity/loadingTime litres of fuel each tick
     * until fuel capacity is reached
     */
    public void tick() {
        TaskType currentTaskType = getTaskList().getCurrentTask().getType();
        if (currentTaskType == TaskType.AWAY) {
            fuelAmount = fuelAmount - characteristics.fuelCapacity * 0.1;
            if (fuelAmount < 0) {
                fuelAmount = 0;
            }
        }
        if (currentTaskType == TaskType.LOAD) {
            fuelAmount = fuelAmount + characteristics.fuelCapacity / getLoadingTime();
            if (fuelAmount > characteristics.fuelCapacity) {
                fuelAmount = characteristics.fuelCapacity;
            }
        }
    }

    /**
     * Returns the human-readable string representation of this aircraft.
     * @return string of format "aircraftType callsign model currentTask" or
     * "aicraftType callsign model currentTask (EMERGENCY)" if in emergency
     * @overrides Object.toString
     */
    public String toString() {
        //placeholder
        if (emergencyState) {
            return "" + getCharacteristics().type.toString() + " " + callSign + " "
                    + getCharacteristics().toString() + " "
                    + getTaskList().getCurrentTask().getType() + " (EMERGENCY)";
        }
        return "" + getCharacteristics().type.toString() + " " + callSign + " "
                + getCharacteristics().toString() + " " + getTaskList().getCurrentTask().getType();

    }
}
