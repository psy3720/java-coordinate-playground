package coordinateCalculator.model;

public class Line extends FigureAbstract {
    public Line(Points points) {
        super(points);
    }

    public Double area() {
        Point pointA = points.get(0);
        Point pointB = points.get(1);

        return Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
    }

    @Override
    public String getAreaInfo() {
        return "두 점 사이의 거리는 " + area();
    }
}
