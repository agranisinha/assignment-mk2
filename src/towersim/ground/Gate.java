package towersim.ground;

import towersim.aircraft.Aircraft;
import towersim.util.NoSpaceException;

/**
 * Represents an aircraft gate with facilities for a single aircraft to be parked.
 *
 * @author tli14
 */
public class Gate {
    /**
     * unique ID number for this gate
     */
    private int gateNumber;

    /**
     * aircraft at this gate
     */
    private Aircraft aircraftAtGate = null;

    /**
     * constructs a new gate with the given gate number
     *
     * @param gateNumber unique identifying number of this gate
     */
    public Gate(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    /**
     * Parks the given aircraft at this gate, so that the gate becomes occupied.
     *
     * @param aircraft aircraft to park at gate
     * @throws NoSpaceException if the gate is already occupied by an aircraft
     */
    public void parkAircraft(Aircraft aircraft) throws NoSpaceException {
        if (aircraftAtGate == null) {
            this.aircraftAtGate = aircraft;
        } else {
            throw new NoSpaceException("There is already an aircraft at gate " + gateNumber);
        }
        //parks a new aircraft at this gate
    }

    /**
     * Removes the currently parked aircraft from the gate.
     * no action taken if no aircraft at gate
     */
    public void aircraftLeaves() {
        aircraftAtGate = null;
    }

    /**
     * Returns the aircraft currently parked at the gate, or null if there is no aircraft parked.
     *
     * @return aircraftAtGate currently parked aircraft, null if none exists
     */
    public Aircraft getAircraftAtGate() {
        return aircraftAtGate;
    }

    /**
     * Returns true if there is an aircraft currently parked at the gate, or false otherwise.
     *
     * @return whether an aircraft is currently parked
     */
    public boolean isOccupied() {
        return aircraftAtGate != null;
    }

    /**
     * Returns this gate's gate number.
     *
     * @return gate number
     */
    public int getGateNumber() {
        return gateNumber;
    }

    /**
     * Returns the human-readable string representation of this gate.
     *
     * @return String of format "Gate gateNumber [callsign]" or "Gate gateNumber ["empty"]" if empty
     */
    public String toString() {
        if (aircraftAtGate == null) {
            return "Gate " + gateNumber + " [empty]";
        }
        return "Gate " + gateNumber + " [" + aircraftAtGate.getCallsign() + "]";
    }

}
