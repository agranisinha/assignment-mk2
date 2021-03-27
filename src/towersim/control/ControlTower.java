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
    private List<Terminal> managedTerminals ;

    public ControlTower(){
        managedAircraft = new ArrayList<Aircraft>();
        managedTerminals = new ArrayList<Terminal>();

    }

    public void addAircraft(Aircraft aircraft)throws NoSuitableGateException{
        if(aircraft.getCharacteristics().type == AircraftType.HELICOPTER) {
            if (aircraft.getTaskList().getCurrentTask().getType() == TaskType.WAIT || aircraft.getTaskList().getCurrentTask().getType() == TaskType.LOAD){
            //try parking at helicopter terminals else throw exception
            }
            managedAircraft.add(aircraft);

        }else{
            if (aircraft.getTaskList().getCurrentTask().getType() == TaskType.WAIT || aircraft.getTaskList().getCurrentTask().getType() == TaskType.LOAD){
                //try parking at plane terminals else throw exception
            }
            managedAircraft.add(aircraft);
        }
    }

    public Gate findUnoccupiedGate(Aircraft aircraft) throws NoSuitableGateException {
        if(aircraft.getCharacteristics().type == AircraftType.AIRPLANE){
            //is plane

        }else{
            //is helicopter
        }
        return new Gate(-1);
    }

    public List<Aircraft> getAircraft(){
        return managedAircraft;
    }

    public void addTerminal(Terminal terminal){
        managedTerminals.add(terminal);
    }

    public List<Terminal> getTerminals(){
        return managedTerminals;
    }

    public Gate findGateOfAircraft(Aircraft targetedAircraft){
        //placeholder
        return new Gate(-1);

    }




    public void tick(){

    }
}
