package coordinateCalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        return pointList.stream()
                .anyMatch(point::equals);
    }

    public int size() {
        return pointList.size();
    }

    public Point get(int index) {
        return pointList.get(index);
    }

    public boolean isEmpty() {
        return pointList.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return Objects.equals(pointList, points.pointList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointList);
    }
}
