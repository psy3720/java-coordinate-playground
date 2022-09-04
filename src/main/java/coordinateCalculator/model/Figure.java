package coordinateCalculator.model;

import coordinateCalculator.model.Point;
import coordinateCalculator.model.Points;

public interface Figure {
    boolean hasPoint(Point point);
    Points getPoints();
    Double area();
    String getAreaInfo();

}
