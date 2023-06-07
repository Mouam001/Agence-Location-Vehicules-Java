package excpetions;

import person.Driver;

public class AlreadyrentException extends Exception{
    public AlreadyrentException(int plateNumber, Driver driver ){
        super(String.format("[%05d] est deja loué(e) à %s",plateNumber,driver.getName()));
    }
}
