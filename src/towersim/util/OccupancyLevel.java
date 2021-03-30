package towersim.util;

/**
 * Denotes a class that has an inherent capacity and a current level of loading relative to that
 * capacity.
 *
 * @author tli14
 */
public interface OccupancyLevel {
    /**
     * Returns the current occupancy level of this entity as a percentage from 0 to 100.
     *
     * @return occupancy level, 0 to 100
     */
    public int calculateOccupancyLevel();
    //returns occupancy level 0 to 100, percent
}
