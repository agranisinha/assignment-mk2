package towersim.aircraft;

import towersim.util.*;
import towersim.tasks.*;

/**
 * Mother class of all aircraft types
 */
public abstract class Aircraft implements EmergencyState, OccupancyLevel, Tickable {
    /**
     *
     */
    public static final double LITRE_OF_FUEL_WEIGHT = 0.8;
    //Weight of a litre of aviation fuel, in kilograms.
    /**
     *
     */
    private boolean emergencyState;
    //the state of emergency of the aircraft
    private String callSign;
    private AircraftCharacteristics characteristics;
    //custom object including name, type, weight, fuel capacity
    //passenger capacity, and freight capacity in an enum
    /**
     *
     */
    private TaskList listOfTasks;
    //custom object list of tasks
    private double fuelAmount;
    //fuel amount in Litres

    /**
     * Constructor
     *
     * @param callsign        callsign of aircraft
     * @param characteristics enum aircraftcharacteristics including model, make, capacity etc
     * @param tasks           list of future tasks to complete
     * @param fuelAmount      current fuel amount of the aircraft
     */
    protected Aircraft(String callsign, AircraftCharacteristics characteristics,
                       TaskList tasks, double fuelAmount) {
        this.callSign = callsign;
        this.characteristics = characteristics;
        this.listOfTasks = tasks;
        this.emergencyState = false;
        this.fuelAmount = fuelAmount;
        //constructs the object
    }


    public void declareEmergency() {
        emergencyState = true;
    }

    public void clearEmergency() {
        emergencyState = false;
    }

    public boolean hasEmergency() {
        return emergencyState;
    }
    //emergency state functions, overriding emergency state interface.

    //getters


    public String getCallsign() {
        return callSign;
    }

    public AircraftCharacteristics getCharacteristics() {
        return characteristics;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getFuelPercentRemaining() {
        //get fuel capacity from characteristics and divide the fuel amount by it then*100
        return (int) (fuelAmount / this.characteristics.fuelCapacity * 100);
    }

    public abstract int getLoadingTime();

    public TaskList getTaskList() {
        return listOfTasks;
    }

    public double getTotalWeight() {
        double fuelWeight = fuelAmount * LITRE_OF_FUEL_WEIGHT;
        double aircraftWeight = this.characteristics.emptyWeight;
        return fuelWeight + aircraftWeight;
        //get fuel weight and plane weight and return SUM
    }
    //getters


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
