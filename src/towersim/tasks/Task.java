package towersim.tasks;

/**
 * Represents a task currently assigned to an aircraft.
 *
 * @author tli14
 */
public class Task {
    /**
     * percentage to load if is a load task, 0 if not load task
     */
    private int loadPercentage;
    /**
     * Enum to represent the possible types of tasks an aircraft can have.
     */
    private TaskType type;

    /**
     * constructs a new task with the given type and 0 load percentage
     *
     * @param type type of task
     */
    public Task(TaskType type) {
        this.type = type;
        loadPercentage = 0;
    }

    /**
     * Creates a new Task of the given task type and stores the given load percentage in the task.
     *
     * @param type           type of task
     * @param loadPercentage percentage of maximum capacity to load
     */
    public Task(TaskType type, int loadPercentage) {
        this.type = type;
        this.loadPercentage = loadPercentage;
    }

    /**
     * Returns the type of this task.
     *
     * @return task type
     */
    public TaskType getType() {
        return type;
    }

    /**
     * Returns the load percentage specified
     *
     * @return task load percentage
     */
    public int getLoadPercent() {
        return loadPercentage;
    }

    /**
     * Returns the human-readable string representation of this task.
     *
     * @return string representation of this task
     */
    public String toString() {
        if (getType() == TaskType.LOAD) {
            return "LOAD at " + loadPercentage + "%";
        } else {
            return type.toString();
        }

        //placeholder
    }
}
