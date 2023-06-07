package excpetions;

import car.Vehicle;

public class NoSuchVehicleException extends Exception{
    public NoSuchVehicleException(int platNumber){
        super(String.format("%s n'existe pas", Vehicle.formatPlateNumber(platNumber)));
    }
}
