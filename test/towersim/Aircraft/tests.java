package towersim.Aircraft;

import towersim.aircraft.AircraftCharacteristics;
import towersim.aircraft.FreightAircraft;
import towersim.tasks.Task;
import towersim.tasks.TaskList;
import towersim.tasks.TaskType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class tests {
        public static void main(String[] args) {
                List<Task> list = new ArrayList<>();
                list.add(new Task(TaskType.LOAD, 50));
                TaskList tasks = new TaskList(list);

                FreightAircraft testingAircraft = new FreightAircraft("testing", AircraftCharacteristics.BOEING_747_8F,
                        tasks,226117, 0);
                System.out.println(testingAircraft.getLoadingTime());

        }
}