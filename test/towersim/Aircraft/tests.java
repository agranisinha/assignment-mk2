package towersim.Aircraft;

import towersim.aircraft.AircraftCharacteristics;
import towersim.aircraft.FreightAircraft;
import towersim.aircraft.PassengerAircraft;
import towersim.control.ControlTower;
import towersim.ground.AirplaneTerminal;
import towersim.ground.Gate;
import towersim.tasks.Task;
import towersim.tasks.TaskList;
import towersim.tasks.TaskType;
import towersim.util.NoSpaceException;
import towersim.util.NoSuitableGateException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class tests {
        public static void main(String[] args) throws NoSpaceException {
                List<Task> list = new ArrayList<>();
                list.add(new Task(TaskType.LOAD, 100));
                TaskList tasks = new TaskList(list);

                FreightAircraft testingAircraft = new FreightAircraft("testing",
                        AircraftCharacteristics.BOEING_747_8F,
                        tasks,226117, 0);
                System.out.println(testingAircraft.toString());
                System.out.println(testingAircraft.getLoadingTime());
                System.out.println(testingAircraft.calculateOccupancyLevel());
                testingAircraft.tick();
                testingAircraft.tick();
                System.out.println(testingAircraft.calculateOccupancyLevel());


                PassengerAircraft testingAircraft2 = new PassengerAircraft("testing2",
                        AircraftCharacteristics.BOEING_787, tasks,AircraftCharacteristics
                        .BOEING_787.fuelCapacity, 0 );
                System.out.println(testingAircraft2.toString());
                System.out.println(testingAircraft2.getLoadingTime());
                System.out.println(testingAircraft2.calculateOccupancyLevel());
                testingAircraft2.tick();
                testingAircraft2.tick();
                System.out.println(testingAircraft2.calculateOccupancyLevel());

                ControlTower testTower = new ControlTower();
                AirplaneTerminal terminal1 = new AirplaneTerminal(1);
                Gate gate1 = new Gate(1);
                terminal1.addGate(gate1);
                testTower.addTerminal(terminal1);
                try {
                        testTower.addAircraft(testingAircraft);
                } catch (NoSuitableGateException e) {
                        e.printStackTrace();
                }
                try {
                        testTower.addAircraft(testingAircraft2);
                } catch (NoSuitableGateException e) {
                        e.printStackTrace();
                }
                System.out.println(terminal1.toString());
                System.out.println(gate1.toString());
        }
}