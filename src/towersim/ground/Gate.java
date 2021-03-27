package towersim.ground;

import towersim.aircraft.Aircraft;

public class Gate {
    private int gateNumber;
    private Aircraft aircraftAtGate = null;

    public Gate(int gateNumber){
        this.gateNumber = gateNumber;
    }

    public void parkAircraft(Aircraft aircraft){
        this.aircraftAtGate = aircraft;
        //parks a new aircraft at this gate
    }

    public void aircraftLeaves(){
        aircraftAtGate = null;
    }

    public Aircraft getAircraftAtGate() {
        return aircraftAtGate;
    }

    public boolean isOccupied(){
        if(aircraftAtGate == null){
            return false;
        }else{
            return true;
        }
    }
    public int getGateNumber(){
        return gateNumber;
    }

    public String toString(){
        return "";
    }

}
