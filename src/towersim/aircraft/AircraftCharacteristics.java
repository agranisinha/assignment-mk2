package towersim.aircraft;
import towersim.aircraft.AircraftType;

public enum AircraftCharacteristics{
    AIRBUS_A320(AircraftType.AIRPLANE, 42600, 27200, 150, 0),
    BOEING_747_8F(AircraftType.AIRPLANE, 197131, 226117, 0, 137756),
    ROBINSON_R44(AircraftType.HELICOPTER, 658, 190, 4,0 ),
    BOEING_787(AircraftType.AIRPLANE, 119950, 126206, 242, 0 ),
    FOKKER_100(AircraftType.AIRPLANE, 24375, 13365, 97, 0),
    SIKORSKY_SKYCRANE(AircraftType.HELICOPTER, 8724, 3328, 0, 0);

    //variables in each aircraftCharacteristics
   public AircraftType type;
   public final int emptyWeight;
   public final double fuelCapacity;
   public final int freightCapacity;
   public final int passengerCapacity;
    //

    //constructor for each aircraftCharacteristics
     AircraftCharacteristics(AircraftType type, int emptyWeight, double fuelCapacity, int passengerCapacity, int freightCapacity){
        this.type = type;
        this.emptyWeight = emptyWeight;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
        this.freightCapacity = freightCapacity;
    }

}
