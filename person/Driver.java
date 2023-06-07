package person;

import location.IsLicenced;
import location.Licence;
import person.Citizen;

import java.util.Calendar;

public class Driver extends Citizen implements IsLicenced {

    Licence licence;
    private String  name;
    public Driver(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setLicenceExpiration(Calendar expiration){
         this.licence = new Licence(expiration);
    }

    @Override
    public Licence getLicence() {
        return this.licence;
    }

    @Override
    public String toString() {
        return String.format("%s,permis valide jussqu'au %2$tA %2$te %2$tB %2$tY",
                super.toString(), this.getLicence().getExpiration());
    }
}
