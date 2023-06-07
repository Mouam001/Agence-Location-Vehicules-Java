package location;

import car.Car;
import car.Vehicle;
import excpetions.AlreadyrentException;
import excpetions.LicenceExpiredException;
import excpetions.NoSuchVehicleException;
import person.Driver;

import java.util.LinkedHashMap;

public class Agency {
    private LinkedHashMap<Vehicle, Driver> vehicles;

    public Agency() {
        vehicles = new LinkedHashMap<>();
    }

    public void register(Vehicle vehicle){
        vehicles.put(vehicle,null);
    }

    public Vehicle getVehicle(int plateNumber) throws NoSuchVehicleException {
            Vehicle vehicle = null;
            int cmptr = 0;
            for(Vehicle cle : vehicles.keySet()){
                if(plateNumber == cle.getPlatNumber()){
                    vehicle = cle;
                } else if(vehicle == null && cmptr>= vehicles.size()){
                    throw  new NoSuchVehicleException(plateNumber);
                }
                cmptr++;
            }
        return vehicle;
    }


    public void rentVehicle(int plateNumber, Driver driver) throws LicenceExpiredException, AlreadyrentException, NoSuchVehicleException {
        if (!Licence.isValid(driver.getLicence())) {
            throw new LicenceExpiredException(driver);
        }

        Vehicle vehicle = this.getVehicle(plateNumber);
        if (vehicle == null) {
            throw new NoSuchVehicleException(plateNumber);
        }

        for (Vehicle v : vehicles.keySet()) {
            if (v == vehicle) {
                if (vehicles.get(v) != null) {
                    throw new AlreadyrentException(plateNumber, driver);
                } else {
                    vehicles.put(v, driver);
                    return;
                }
            }
        }
    }


    public Vehicle findVehicle(Class<? extends Vehicle>typeVehicle){
        for(Vehicle vehicle : vehicles.keySet()){
            if(typeVehicle.isInstance(vehicle) && vehicles.get(vehicle) == null){
                return vehicle;
            }
        }
        return null;
    }

    public Car rentCarTo(Driver driver) throws LicenceExpiredException {
        Car car = (Car)findVehicle(Car.class);
        if (car != null) {
            try {
                rentVehicle(car.getPlatNumber(), driver);
                return car;
            } catch (NoSuchVehicleException | AlreadyrentException e) {
                // Ces exceptions n'ont aucun sens ici, donc nous les ignorerons
            }
        }
        return null;
    }


    public void showVehicles() {
        for(Vehicle vehicle : vehicles.keySet()){
            String status = (vehicles.get(vehicle)) == null ? "Free" : "Used";
            System.out.printf("%-5s [%05d] : %2s \n",vehicle.getClass().getSimpleName(),vehicle.getPlatNumber(),status);
        }

    }

}
