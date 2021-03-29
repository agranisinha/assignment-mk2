package towersim.ground;

import towersim.aircraft.AircraftType;
import towersim.util.EmergencyState;
import towersim.util.NoSpaceException;
import towersim.util.NoSuitableGateException;
import towersim.util.OccupancyLevel;

import java.util.List;
import java.util.ArrayList;

public abstract class Terminal implements EmergencyState, OccupancyLevel {
    public static final int MAX_NUM_GATES = 6;
    private List<Gate> gatesList = new ArrayList<Gate>();
    int terminalNumber;
    private boolean emergencyState;

    protected Terminal(int terminalNumber) {
        this.terminalNumber = terminalNumber;
        emergencyState = false;
    }

    public int getTerminalNumber() {
        return terminalNumber;
    }

    public void addGate(Gate gate) throws NoSpaceException {
        if (gatesList.size() >= MAX_NUM_GATES) {
            throw new NoSpaceException("this Terminal cannot host more gates");
        } else {
            gatesList.add(gate);
        }
    }

    public List<Gate> getGates() {
        return gatesList;
    }

    public Gate findUnoccupiedGate() throws NoSuitableGateException {
        for (int i = 0; i < gatesList.size(); i++) {
            if (!gatesList.get(i).isOccupied()) {
                return gatesList.get(i);
            }
        }
        throw new NoSuitableGateException("all gates are occupied by aircrafts");
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

    public String toString() {
        if (emergencyState) {
            return this.getClass().getSimpleName() +" "+ terminalNumber + ", " + gatesList.size() + " gates" + "(EMERGENCY)";
        }
        return this.getClass().getSimpleName() +" "+ terminalNumber + ", " + gatesList.size() + " gates";

    }


}
