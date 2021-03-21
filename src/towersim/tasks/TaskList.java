package towersim.tasks;
import java.util.*;

public class TaskList {
    private ArrayList<Task> listOfTasks;
    private int currentTask = 0;
    public TaskList(List<Task> tasks){
        listOfTasks = (ArrayList<Task>)tasks;
    }
    public Task getCurrentTask(){
        return listOfTasks.get(currentTask);
    }
    public Task getNextTask(){
        if(currentTask == listOfTasks.size()){
            return listOfTasks.get(0);
        }else {
            return listOfTasks.get(currentTask + 1);
        }
    }
    public void moveToNextTask(){
        currentTask++;
            if(currentTask == listOfTasks.size()){
                currentTask = 0;
            }
    }
    public String toString(){
        //placeholder
        return "";
    }



}
