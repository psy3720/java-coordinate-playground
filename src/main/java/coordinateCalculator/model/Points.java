package coordinateCalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Points {
    List<Point> pointList;

    public Points() {
        this.pointList = new ArrayList<>();
    }

    public Points(List<Point> pointList) {
        this.pointList = pointList;
    }

    public void add(Point point) {
        pointList.add(point);
    }

    public boolean hasPoint(Point point) {
        return pointList.stream().filter(point::equals).findFirst().isPresent();
    }

    public int size() {
        return pointList.size();
    }

    public Point get(int index) {
        return pointList.get(index);
    }
}
