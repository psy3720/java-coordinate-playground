package rentCompany;

public class K5 extends RentCar {
    private static final int DISTANCE_PER_LITER = 13;
    private String name;

    public K5(double tripDistance) {
        super(tripDistance);
        name = "K5";
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
