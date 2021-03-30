package towersim.util;

/**
 * Denotes an entity whose behaviour and operations can be affected by emergencies.
 */
public interface EmergencyState {
    /**
     * declares emergency state of aircraft
     */
    public void declareEmergency();


    /**
     * clears current emergency
     */
    public void clearEmergency();


    /**
     * returns current status of emergence for aircraft
     *
     * @return if has emergency
     */
    public boolean hasEmergency();

}
