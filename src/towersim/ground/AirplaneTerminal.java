package towersim.ground;

import towersim.aircraft.AircraftType;

public class AirplaneTerminal extends Terminal{

    public AirplaneTerminal(int terminalNumber) {
        super(terminalNumber);
        this.terminalType = AircraftType.AIRPLANE;
    }
}
