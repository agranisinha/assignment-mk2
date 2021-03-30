package towersim.ground;

import org.junit.Assert;
import towersim.aircraft.AircraftCharacteristics;
import towersim.aircraft.PassengerAircraft;
import towersim.ground.Gate;
// add any required imports here
import org.junit.Test;
import towersim.tasks.Task;
import towersim.tasks.TaskList;
import towersim.tasks.TaskType;

import java.util.ArrayList;
import java.util.List;

/**
 * Testing methods for class Gate
 */
public class GateTest {
    /**
     * gate test will be conducted in
     */
    Gate testingGate;
    /**
     * testing tasklist for generating airplanes
     */
    List<Task> list = new ArrayList<>();

    /**
     * testing tasklist for generating airplanes
     */
    TaskList tasks = new TaskList(list);

    /**
     * Testing airplane for testing gates
     */
    PassengerAircraft testingAircraft2 = new PassengerAircraft("testing2",
            AircraftCharacteristics.BOEING_787, tasks, AircraftCharacteristics
            .BOEING_787.fuelCapacity, 0);

    // add unit tests here

    /**
     * Tests for constructing a gate and checking its gatenumber
     */
    @Test
    public void getSetGateTest() {
        testingGate = new Gate(1);
        Assert.assertEquals(1, testingGate.getGateNumber());
    }

    /**
     * Test for parking an aircraft at testing gate
     */
    @Test
    public void parkAircraftTest() {
        testingGate = new Gate(1);
        try {
            testingGate.parkAircraft(testingAircraft2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(testingGate.getAircraftAtGate(), testingAircraft2);

    }

    /**
     * test that aircraft leaves the gate when aircraftLeaves is called
     */
    @Test
    public void leavesAircraftTest() {
        testingGate = new Gate(1);
        try {
            testingGate.parkAircraft(testingAircraft2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        testingGate.aircraftLeaves();
        Assert.assertEquals(testingGate.getAircraftAtGate(), null);
    }

    /**
     * tests that gate returns correctly if testing airplane is parked at the gate
     */
    @Test
    public void isOccupiedTest() {
        testingGate = new Gate(1);
        try {
            testingGate.parkAircraft(testingAircraft2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(testingGate.isOccupied(), true);

    }


    /**
     * Test that the string returned is correct and of the same format
     */
    @Test
    public void getStringTest() {
        testingGate = new Gate(1);
        try {
            testingGate.parkAircraft(testingAircraft2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(testingGate.toString(), "Gate " + testingGate.getGateNumber()
                + " [" + testingAircraft2.getCallsign() + "]");
    }


}
