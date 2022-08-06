package rentCompany;

public class Avante extends RentCar {
    private static final int DISTANCE_PER_LITER = 15;
    private String name;

    public Avante(double tripDistance) {
        super(tripDistance);
        name = "Avante";
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return name;
    }
}
