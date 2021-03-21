package towersim.util;

public interface EmergencyState {
    public void declareEmergency();
    //declares emergency state of aircraft
    public void clearEmergency();
    //clears current or any emergency
    public boolean hasEmergency();
    //returns current status of emergence for aircraft

}
