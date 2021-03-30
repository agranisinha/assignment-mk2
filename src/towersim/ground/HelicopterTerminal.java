package towersim.ground;

import towersim.aircraft.AircraftType;

/**
 * Represents an airport terminal that is designed to accommodate helicopters.
 *
 * @author tli14
 */
public class HelicopterTerminal extends Terminal {

    /**
     * Constructs a new helicopter terminal with the given terminal number
     *
     * @param terminalNumber unique terminal number for new terminal
     */
    public HelicopterTerminal(int terminalNumber) {
        super(terminalNumber);
    }
}
