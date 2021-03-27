package towersim.tasks;

import java.lang.*;

public enum TaskType {
    AWAY("AWAY means that aircraft are either flying or at other airports."),
    LAND("Aircraft in LAND are circling around the airport waiting for a slot to land."),
    WAIT("LOAD tasks represent the aircraft loading its cargo at the gate."),
    LOAD("Aircraft in TAKEOFF are waiting on taxiways for a slot to take off."),
    TAKEOFF("WAIT tells an aircraft to stay stationary at a gate and not load any cargo.");
    private final String description;

    TaskType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }


}
