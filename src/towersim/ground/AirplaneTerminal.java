package towersim.ground;

import towersim.aircraft.AircraftType;

/**
 * Represents an airport terminal that is designed to accommodate airplanes.
 *
 * @author tli14
 */
public class AirplaneTerminal extends Terminal {

    /**
     * Constructs a new airplane terminal with the given terminal number
     *
     * @param terminalNumber unique terminal number of new airplane terminal
     */
    public AirplaneTerminal(int terminalNumber) {
        super(terminalNumber);
    }
}
