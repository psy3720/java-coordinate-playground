package coordinateCalculator.model;

public class FigureAbstract implements Figure {
    Points points;

    public FigureAbstract(Points points) {
        this.points = points;
    }

    @Override
    public boolean hasPoint(Point point) {
        return points.hasPoint(point);
    }

    @Override
    public Points getPoints() {
        return points;
    }

    public Double area() {
        return null;
    }

    public String getAreaInfo() {
        return null;
    }
}
