package car;

public class Vehicle {

    private static int NEXT_NUMBER = 1;//attribution automatique de numero de plaque
    private int platNumber;

    public Vehicle() {
        this.platNumber = NEXT_NUMBER++;
    }

    public static String formatPlateNumber(int platNumber){
        return String.format("[%05d]",platNumber);
    }

    public int getPlatNumber() {
        return platNumber;
    }

    @Override
    public String toString() {
        return String.format("%1$-5s %2$s",
                this.getClass().getSimpleName(),formatPlateNumber(platNumber));
    }

}
