package towersim.aircraft;

import towersim.aircraft.AircraftType;

/**
 * Aircraft characteristics saved in a constant enum form
 *
 * @author tli14
 */
public enum AircraftCharacteristics {
    /**
     * Narrow-body twin-jet airliner.
     */
    AIRBUS_A320(AircraftType.AIRPLANE, 42600, 27200, 150, 0),
    /**
     * Wide-body quad-jet freighter.
     */
    BOEING_747_8F(AircraftType.AIRPLANE, 197131, 226117, 0, 137756),
    /**
     * Long range, wide-body twin-jet airliner.
     */
    ROBINSON_R44(AircraftType.HELICOPTER, 658, 190, 4, 0),
    /**
     * Twin-jet regional airliner.
     */
    BOEING_787(AircraftType.AIRPLANE, 119950, 126206, 242, 0),
    /**
     * Four-seater light helicopter.
     */
    FOKKER_100(AircraftType.AIRPLANE, 24375, 13365, 97, 0),
    /**
     * Twin-engine heavy-lift helicopter.
     */
    SIKORSKY_SKYCRANE(AircraftType.HELICOPTER, 8724, 3328, 0, 9100);

    //variables in each aircraftCharacteristics
    /**
     * Type of aircraft.
     */
    public final AircraftType type;
    /**
     * Weight of aircraft with no load or fuel, in kilograms.
     */
    public final int emptyWeight;
    /**
     * Maximum amount of fuel able to be carried, in litres.
     */
    public final double fuelCapacity;
    /**
     * Maximum amount of freight able to be carried, in kilograms.
     */
    public final int freightCapacity;
    /**
     * Maximum number of passengers able to be carried.
     */
    public final int passengerCapacity;
    //

    //constructor for each aircraftCharacteristics

    /**
     * Constructs a final aircraft type at the initiation of the enum and populate
     * the fields of that specific enum
     *
     * @param type
     * @param emptyWeight
     * @param fuelCapacity
     * @param passengerCapacity
     * @param freightCapacity
     */
    AircraftCharacteristics(AircraftType type, int emptyWeight, double fuelCapacity,
                            int passengerCapacity, int freightCapacity) {
        this.type = type;
        this.emptyWeight = emptyWeight;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
        this.freightCapacity = freightCapacity;
    }

}
