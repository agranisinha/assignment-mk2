package towersim.tasks;

import java.lang.*;

public enum TaskType {
    AWAY("Flying outside the airport"),
    LAND("Waiting in queue to land"),
    WAIT("Waiting idle at gate"),
    LOAD("Loading at gate"),
    TAKEOFF("Waiting in queue to take off");
    private final String description;

    TaskType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }


}
