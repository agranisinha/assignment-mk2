package towersim.tasks;

public class Task {
    private int loadPercentage;
    private TaskType type;

    public Task(TaskType type) {
        this.type = type;
        loadPercentage = 0;
    }

    public Task(TaskType type, int loadPercentage) {
        this.type = type;
        this.loadPercentage = loadPercentage;
    }

    public TaskType getType() {
        return type;
    }

    public int getLoadPercent() {
        return loadPercentage;
    }

    public String toString() {
        return "";
        //placeholder
    }
}
