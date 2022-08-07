package coordinateCalculator;

public class Line {
    Positions positions;

    public Line(Positions positions) {
        validate(positions);
        this.positions = positions;
    }

    private void validate(Positions positions) {
        if (positions.size() != 2) {
            throw new RuntimeException();
        }
    }

    public double length() {
        Position positionA = positions.get(0);
        Position positionB = positions.get(1);
        double powX = Math.pow(positionA.getX() - positionB.getX(), 2);
        double powY = Math.pow(positionA.getY() - positionB.getY(), 2);

        return Math.sqrt(powX + powY);
    }
}
