package towersim.ground;

import towersim.util.EmergencyState;
import towersim.util.OccupancyLevel;

import java.util.List;
import java.util.ArrayList;

public abstract class Terminal implements EmergencyState, OccupancyLevel {
    static int MAX_NUM_GATES = 6;
    private List<Gate> gatesList = new ArrayList<Gate>();
    int terminalNumber;

    protected Terminal(int terminalNumber){
        this.terminalNumber = terminalNumber;
    }



}
