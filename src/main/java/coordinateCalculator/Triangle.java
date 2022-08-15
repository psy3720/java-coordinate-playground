package coordinateCalculator;

public class Triangle implements Figure {
    private final Points points;

    public Triangle(Points points) {
        validate(points);
        this.points = points;
    }

    private void validate(Points points) {
        if(points.size() != 3) {
            throw new RuntimeException();
        }
    }

    @Override
    public double getField() {
        Point point = points.get(0);
        Point point1 = points.get(1);
        Point point2 = points.get(2);

        double a = getWidth(point, point1);
        double b = getWidth(point1, point2);
        double c = getWidth(point, point2);
        double s = (a + b + c) / 2;
        double S = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        return Math.round(S);
    }

    @Override
    public String getFigure() {
        return "삼각형 넓이는 ";
    }

    public double getWidth(Point pointX, Point pointY) {
        double powX = Math.pow(pointX.getX() - pointY.getX(), 2);
        double powY = Math.pow(pointX.getY() - pointY.getY(), 2);

        return Math.sqrt(powX + powY);
    }
}
