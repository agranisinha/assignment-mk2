package towersim.tasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
// add any required imports here

public class TaskListTest {


    // add unit tests here

    /**
     * tests getCurrentTask()
     */
    @Test
    public void testGetCurrentTask() {
        List<Task> testList = new ArrayList<>();
        Task expected = new Task(TaskType.LOAD);
        testList.add(expected);
        testList.add(new Task(TaskType.TAKEOFF));
        TaskList testingTasks = new TaskList(testList);
        Assert.assertEquals(testingTasks.getCurrentTask(), expected);
    }

    /**
     * Tests getNextTask()
     */
    @Test
    public void testGetNextTask() {
        List<Task> testList = new ArrayList<>();
        Task expected = new Task(TaskType.LOAD);
        testList.add(new Task(TaskType.TAKEOFF));
        testList.add(expected);
        TaskList testingTasks = new TaskList(testList);
        Assert.assertEquals(testingTasks.getNextTask(), expected);
    }

    @Test
    /**
     * Tests moveToNextTask()
     */
    public void testMoveToNextTask() {
        List<Task> testList = new ArrayList<>();
        Task expected = new Task(TaskType.LOAD);
        testList.add(new Task(TaskType.TAKEOFF));
        testList.add(expected);
        TaskList testingTasks = new TaskList(testList);
        testingTasks.moveToNextTask();
        Assert.assertEquals(testingTasks.getCurrentTask(), expected);
    }

    /**
     * Tests for internal logic circular in getNextTask()
     */
    @Test
    public void testCircularNextTask() {
        List<Task> testList = new ArrayList<>();
        Task expected = new Task(TaskType.LOAD);
        testList.add(expected);
        testList.add(new Task(TaskType.TAKEOFF));
        TaskList testingTasks = new TaskList(testList);
        testingTasks.moveToNextTask();
        Assert.assertEquals(testingTasks.getNextTask(), expected);
    }

    /**
     * Tests for internal logic circular in moveToNextTask()
     */
    @Test
    public void testCircularMoveTask() {
        List<Task> testList = new ArrayList<>();
        Task expected = new Task(TaskType.LOAD);
        testList.add(expected);
        testList.add(new Task(TaskType.TAKEOFF));
        TaskList testingTasks = new TaskList(testList);
        testingTasks.moveToNextTask();
        testingTasks.moveToNextTask();
        Assert.assertEquals(testingTasks.getCurrentTask(), expected);
    }

    /**
     * Tests correct output from toString
     */
    @Test
    public void testToString() {
        List<Task> testList = new ArrayList<>();
        Task expected = new Task(TaskType.LOAD);
        testList.add(new Task(TaskType.TAKEOFF));
        testList.add(expected);
        TaskList testingTasks = new TaskList(testList);
        String expectedString = "TaskList currently on " + testingTasks.getCurrentTask().getType()
                + " [" + "1" + "/" + "2" + "]";
        Assert.assertEquals(testingTasks.toString(), expectedString);
    }


}
