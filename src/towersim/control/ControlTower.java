package towersim.control;

import towersim.aircraft.Aircraft;
import towersim.aircraft.AircraftType;
import towersim.tasks.Task;
import towersim.tasks.TaskType;
import towersim.util.NoSpaceException;
import towersim.util.NoSuitableGateException;
import towersim.util.Tickable;
import towersim.ground.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Control tower class
 *
 * @author tli14
 */
public class ControlTower implements Tickable {
    /**
     * List of aircraft controlled by this control tower
     */
    private List<Aircraft> managedAircraft;
    /**
     * list of terminals controlled by this control tower
     */
    private List<Terminal> managedTerminals;

    /**
     * Creates a new ControlTower.
     */
    public ControlTower() {
        managedAircraft = new ArrayList<Aircraft>();
        managedTerminals = new ArrayList<Terminal>();

    }

    /**
     * Adds the given aircraft to the jurisdiction of this control tower.
     *
     * @param aircraft Aircraft to be added
     * @throws NoSuitableGateException if no gate is suitable for adding aircraft
     */
    public void addAircraft(Aircraft aircraft) throws NoSuitableGateException {

        if (aircraft.getTaskList().getCurrentTask().getType() == TaskType.WAIT
                || aircraft.getTaskList().getCurrentTask().getType() == TaskType.LOAD) {
            //try parking at  terminals else throw exception
            Gate suitableGate = null;
            try {
                suitableGate = findUnoccupiedGate(aircraft);

            } catch (NoSuitableGateException noGateException) {
                throw noGateException;
            }
            if (suitableGate != null) {
                try {
                    suitableGate.parkAircraft(aircraft);

                } catch (NoSpaceException noSpaceException) {
                    throw new NoSuitableGateException();
                }
            }
        }

        managedAircraft.add(aircraft);


    }

    /**
     * Attempts to find an unoccupied gate in a compatible terminal for the given aircraft.
     *
     * @param aircraft aircraft for which to find gate
     * @return gate gate for given aircraft if one exists
     * @throws NoSuitableGateException if no suitable gate could be found
     */
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

    /**
     * returns list of all managed aircraft
     *
     * @return managedAircraft
     */
    public List<Aircraft> getAircraft() {
        return managedAircraft;
    }

    /**
     * Adds the given terminal to the jurisdiction of this control tower.
     *
     * @param terminal terminal to add
     */
    public void addTerminal(Terminal terminal) {
        managedTerminals.add(terminal);
    }

    /**
     * returns list of all managed terminals
     *
     * @return managedTerminals
     */
    public List<Terminal> getTerminals() {
        return managedTerminals;
    }

    /**
     * Finds the gate where the given aircraft is parked, and returns null if the aircraft
     * is not parked at any gate in any terminal.
     *
     * @param targetedAircraft aircraft whose gate to find
     * @return gate gate occupied by the given aircraft; or null if none exists
     */
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

    /**
     * Advances the simulation by one tick.
     */
    public void tick() {
        for (Aircraft loopedAircraft : managedAircraft) {
            loopedAircraft.tick();
        }
    }
}
