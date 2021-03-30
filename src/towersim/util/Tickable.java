package towersim.util;

/**
 * Denotes a class whose state changes on every tick of the simulation.
 *
 * @author tli14
 */
public interface Tickable {

    /**
     * Method to be called once on every simulation tick.
     */
    public void tick();
    //ticks the time forwards 1 tick.
}
