package location;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Licence {
    private Calendar expiration;

    public Licence(Calendar expiration) {
        this.expiration = expiration;
    }

    public Calendar getExpiration() {
        return expiration;
    }


    public static boolean isValid(Licence licence){
        Date today = GregorianCalendar.getInstance(Locale.FRANCE).getTime();
        return  licence.getExpiration().getTime().after(today);
    }
}
