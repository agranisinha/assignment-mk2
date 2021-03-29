package towersim.ground;

import towersim.aircraft.Aircraft;
import towersim.util.NoSpaceException;

public class Gate {
    private int gateNumber;
    private Aircraft aircraftAtGate = null;

    public Gate(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void parkAircraft(Aircraft aircraft) throws NoSpaceException {
        if (aircraftAtGate == null) {
            this.aircraftAtGate = aircraft;
        } else {
            throw new NoSpaceException("There is already an aircraft at gate " + gateNumber);
        }
        //parks a new aircraft at this gate
    }

    public void aircraftLeaves() {
        aircraftAtGate = null;
    }

    public Aircraft getAircraftAtGate() {
        return aircraftAtGate;
    }

    public boolean isOccupied() {
        return aircraftAtGate != null;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public String toString() {
        if(aircraftAtGate == null){
            return "Gate " + gateNumber + " [empty]";
        }
        return "Gate " + gateNumber + " [" + aircraftAtGate.getCallsign()+"]";
    }

}
