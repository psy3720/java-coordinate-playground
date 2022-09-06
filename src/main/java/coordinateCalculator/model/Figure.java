package coordinateCalculator.model;

public interface Figure {
    boolean hasPoint(Point point);
    Points getPoints();
    Double area();
    String getAreaInfo();
}
