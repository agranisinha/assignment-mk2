package towersim.ground;

import towersim.aircraft.AircraftType;
import towersim.util.EmergencyState;
import towersim.util.NoSpaceException;
import towersim.util.NoSuitableGateException;
import towersim.util.OccupancyLevel;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents an airport terminal building, containing several aircraft gates.
 *
 * @author tli14
 */
public abstract class Terminal implements EmergencyState, OccupancyLevel {
    /**
     * Maximum possible number of gates allowed at a single terminal.
     */
    public static final int MAX_NUM_GATES = 6;
    /**
     * List of gates contained in this terminal
     */
    private List<Gate> gatesList = new ArrayList<Gate>();
    /**
     * unique identification number of this terminal
     */
    int terminalNumber;
    /**
     * representing a state of emergency for this terminal
     */
    private boolean emergencyState;

    /**
     * Constructs a new terminal with the given terminal number
     *
     * @param terminalNumber identifying number of this terminal
     * @requires terminalNumber to be unique
     */
    protected Terminal(int terminalNumber) {
        this.terminalNumber = terminalNumber;
        emergencyState = false;
    }

    /**
     * Returns this terminal's terminal number.
     *
     * @return terminal number
     */
    public int getTerminalNumber() {
        return terminalNumber;
    }

    /**
     * Adds a gate to the terminal.
     *
     * @param gate gate to add to terminal
     * @throws NoSpaceException if there is no space at the terminal for the new gate
     */
    public void addGate(Gate gate) throws NoSpaceException {
        if (gatesList.size() >= MAX_NUM_GATES) {
            throw new NoSpaceException("this Terminal cannot host more gates");
        } else {
            gatesList.add(gate);
        }
    }

    /**
     * Returns a new instance list of all gates in the terminal.
     *
     * @return list of terminal's gates
     */
    public List<Gate> getGates() {
        List<Gate> getGatesClone = new ArrayList<Gate>(gatesList);
        return getGatesClone;
    }

    /**
     * Finds and returns the first non-occupied gate in this terminal.
     *
     * @return first non-occupied gate in this terminal
     * @throws NoSuitableGateException if all gates in this terminal are occupied
     */
    public Gate findUnoccupiedGate() throws NoSuitableGateException {
        for (int i = 0; i < gatesList.size(); i++) {
            if (!gatesList.get(i).isOccupied()) {
                return gatesList.get(i);
            }
        }
        throw new NoSuitableGateException("all gates are occupied by aircrafts");
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
     * Returns whether or not a state of emergency is currently active.
     *
     * @return true if in emergency; false otherwise
     */
    public boolean hasEmergency() {
        return emergencyState;
    }

    /**
     * Returns the ratio of occupied gates to total gates as a percentage from 0 to 100.
     *
     * @return percentage of occupied gates in this terminal, 0 to 100 rounded to nearest int
     */
    public int calculateOccupancyLevel() {
        if (gatesList.size() == 0) {
            return 0;
        } else {
            int freeGates = 0;
            for (int i = 0; i < gatesList.size(); i++) {
                if (!gatesList.get(i).isOccupied()) {
                    freeGates++;
                }
            }
            return (int) Math.round((100 - ((double) freeGates / (double) gatesList.size()) * 100));

        }
    }

    /**
     * Returns the human-readable string representation of this terminal.
     * in the format of
     * TerminalType terminalNum, numGates gates +"" or "(EMERGENCY)" if in emergency
     *
     * @return string representation of this terminal
     */
    public String toString() {
        if (emergencyState) {
            return this.getClass().getSimpleName() + " " + terminalNumber + ", "
                    + gatesList.size() + " gates" + "(EMERGENCY)";
        }
        return this.getClass().getSimpleName() + " " + terminalNumber + ", " + gatesList.size()
                + " gates";

    }


}
