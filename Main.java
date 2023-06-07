import car.Car;
import car.Truck;
import excpetions.AlreadyrentException;
import excpetions.LicenceExpiredException;
import excpetions.NoSuchVehicleException;
import location.Agency;
import person.Driver;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws NoSuchVehicleException, NoSuchVehicleException, AlreadyrentException, LicenceExpiredException {
        Driver nicolas = new Driver("Soulé ");
        Calendar calendar = GregorianCalendar.getInstance(Locale.FRANCE);
        calendar.set(2023,Calendar.JUNE,9);
        nicolas.setLicenceExpiration(calendar);

        Agency agency = new Agency();
        Car car = new Car();
        Car car1 = new Car();
        Truck truck = new Truck();
        Truck truck1 = new Truck();
        agency.register(car);
        agency.register(car1);
        agency.register(truck);

        // Exemple d'utilsations partie final
        System.out.println( " === Etat de l'agence au depart  : ");
        agency.showVehicles();
        System.out.println();

        Driver vinDiesel = new Driver("Vin Diesel");
        Calendar expiration = GregorianCalendar.getInstance(Locale.FRANCE);
        expiration.set( 2023,Calendar.OCTOBER, 9);
        vinDiesel.setLicenceExpiration(expiration);

        System.out.println("On loue la voiture immatriculée 00001 a Vin");
        agency.rentVehicle(1,vinDiesel);
        agency.showVehicles();
        System.out.println();

        System.out.println("On loue une voiture a Vin");
        Car found = agency.rentCarTo(vinDiesel);
        if(found != null){
            System.out.println(found + " a été louée !");
        }
        agency.showVehicles();

    }

}
