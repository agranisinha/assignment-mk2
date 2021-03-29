package towersim.tasks;

import java.util.*;

public class TaskList {
    private List<Task> listOfTasks;
    private int currentTask = 0;

    public TaskList(List<Task> tasks) {
        listOfTasks = tasks;
    }


    public Task getCurrentTask() {
        //System.out.println("current task is" + currentTask + "of type" +
        // listOfTasks.get(currentTask).getLoadPercent());
        return listOfTasks.get(currentTask);
    }

    public Task getNextTask() {
        if (currentTask == listOfTasks.size()-1) {
            return listOfTasks.get(0);
        } else {
            return listOfTasks.get(currentTask + 1);
        }
    }

    public void moveToNextTask() {
        currentTask++;
        if (currentTask == listOfTasks.size()) {
            currentTask = 0;
        }
    }

    public String toString() {
        //placeholder
        return "";
    }


}
