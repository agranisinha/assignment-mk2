package towersim.control;

import towersim.aircraft.Aircraft;
import towersim.aircraft.AircraftType;
import towersim.tasks.Task;
import towersim.tasks.TaskType;
import towersim.util.NoSuitableGateException;
import towersim.util.Tickable;
import towersim.ground.*;

import java.util.ArrayList;
import java.util.List;

public class ControlTower implements Tickable {

    private List<Aircraft> managedAircraft;
    private List<Terminal> managedTerminals;

    public ControlTower() {
        managedAircraft = new ArrayList<Aircraft>();
        managedTerminals = new ArrayList<Terminal>();

    }

    public void addAircraft(Aircraft aircraft) throws NoSuitableGateException {

        if (aircraft.getTaskList().getCurrentTask().getType() == TaskType.WAIT ||
                aircraft.getTaskList().getCurrentTask().getType() == TaskType.LOAD) {
            //try parking at  terminals else throw exception
            try {
                Gate suitableGate = findUnoccupiedGate(aircraft);
                managedAircraft.add(aircraft);
            } catch (NoSuitableGateException noGateException) {
                throw noGateException;
            }
        } else {
            managedAircraft.add(aircraft);
        }

    }

    public Gate findUnoccupiedGate(Aircraft aircraft) throws NoSuitableGateException {
        if (aircraft.getCharacteristics().type == AircraftType.AIRPLANE) {
            for (int i = 0; i < managedTerminals.size(); i++) {
                Terminal currentSearched = managedTerminals.get(i);
                if (currentSearched.getClass() == AirplaneTerminal.class) {
                    Gate unoccupiedGate;
                    try {
                        unoccupiedGate = currentSearched.findUnoccupiedGate();
                        return unoccupiedGate;
                    } catch (NoSuitableGateException noGateException) {
                        throw noGateException;
                    }

                }
            }

            //is plane

        } else {
            for (int i = 0; i < managedTerminals.size(); i++) {
                Terminal currentSearched = managedTerminals.get(i);
                if (currentSearched.getClass() == HelicopterTerminal.class) {
                    Gate unoccupiedGate;
                    try {
                        unoccupiedGate = currentSearched.findUnoccupiedGate();
                        return unoccupiedGate;
                    } catch (NoSuitableGateException noGateException) {
                        throw noGateException;
                    }

                }
            }

            //is helicopter
        }
        throw new NoSuitableGateException();
    }

    public List<Aircraft> getAircraft() {
        return managedAircraft;
    }

    public void addTerminal(Terminal terminal) {
        managedTerminals.add(terminal);
    }

    public List<Terminal> getTerminals() {
        return managedTerminals;
    }

    public Gate findGateOfAircraft(Aircraft targetedAircraft) {
        //placeholder
        for (int i = 0; i < managedTerminals.size(); i++) {
            List<Gate> gateOfTargetedTerminal = managedTerminals.get(i).getGates();
            for (int j = 0; j < gateOfTargetedTerminal.size(); j++) {
                if (gateOfTargetedTerminal.get(j).getAircraftAtGate() == targetedAircraft) {
                    return gateOfTargetedTerminal.get(j);
                }
            }
        }
        return null;

    }


    public void tick() {

    }
}
