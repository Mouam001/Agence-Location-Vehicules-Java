package excpetions;

import person.Driver;

public class LicenceExpiredException extends Exception{
        public  LicenceExpiredException(Driver driver){
            super(String.format("Le permis de %s a expiré ! ",driver.getName()));
        }


}
