package rentCompany;

public class Sonata extends RentCar {
    private static final int DISTANCE_PER_LITER = 10;
    private String name;

    public Sonata(double tripDistance) {
        super(tripDistance);
        name = "Sonata";
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
