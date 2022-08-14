package coordinateCalculator;

public class Line extends Figure {
    Points points;

    public Line(Points points) {
        validate(points);
        this.points = points;
    }

    private void validate(Points points) {
        if (points.size() != 2) {
            throw new RuntimeException();
        }
    }

    public double getField() {
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        double powX = Math.pow(pointA.getX() - pointB.getX(), 2);
        double powY = Math.pow(pointA.getY() - pointB.getY(), 2);

        return Math.sqrt(powX + powY);
    }

    public String getFigure() {
        return "두 점 사이의 거리는 ";
    }
}
