package towersim.tasks;

import java.util.*;

/**
 * Creates a new TaskList with the given list of tasks.
 *
 * @author tli14
 */
public class TaskList {
    /**
     * List of tasks
     */
    private List<Task> listOfTasks;

    /**
     * counter for the current task
     */
    private int currentTask = 0;

    /**
     * Constructs a new tasklist with the specified list of tasks
     *
     * @param tasks list of tasks
     */
    public TaskList(List<Task> tasks) {
        listOfTasks = tasks;
    }

    /**
     * Returns the current task in the list.
     *
     * @return current task or null if empty
     */
    public Task getCurrentTask() {
        if (listOfTasks.size() == 0) {
            return null;
        } else {
            return listOfTasks.get(currentTask);
        }
    }

    /**
     * Returns the task in the list that comes after the current task.
     * does not move to next task
     *
     * @return next task circularly linked from last to first
     */
    public Task getNextTask() {
        if (currentTask == listOfTasks.size() - 1) {
            return listOfTasks.get(0);
        } else {
            return listOfTasks.get(currentTask + 1);
        }
    }

    /**
     * Moves the reference to the current task forward by one in the circular task list.
     */
    public void moveToNextTask() {
        currentTask++;
        if (currentTask == listOfTasks.size()) {
            currentTask = 0;
        }
    }

    /**
     * Returns the human-readable string representation of this task list.
     *
     * @return String of format TaskList currently on currentTask [taskNum/totalNumTasks]
     */
    public String toString() {
        //placeholder
        return "TaskList currently on " + getCurrentTask().getType() + " [" + (currentTask + 1)
                + "/" + listOfTasks.size() + "]";
    }


}
