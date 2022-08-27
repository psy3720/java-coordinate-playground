package coordinateCalculator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int LINE_COORDINATE_SIZE = 2;
    List<Point> points;

    public Line(String coordinate) {
        validate(coordinate);
        points = new ArrayList<>();

        createLine(coordinate);
    }

    private void createLine(String coordinate) {
        String[] split = coordinate.split("-");

        for(String s : split) {
            String[] coordinateSplit = s.replaceAll("[^\\d|,]", "").split(",");

            int x = Integer.parseInt(coordinateSplit[0]);
            int y = Integer.parseInt(coordinateSplit[1]);

            points.add(new Point(x, y));
        }
    }

    private void validate(String coordinate) {
        String[] split = coordinate.split("-");

        if(split.length != LINE_COORDINATE_SIZE) {
            throw new RuntimeException("좌표를 올바르게 입력해주세요.");
        }
    }

    public boolean hasPoints(List<Point> points) {
        boolean result = true;

        for(Point point: points) {
            if(!this.points.contains(point)) {
                return false;
            }
        }

        return result;
    }

    public Double length() {
        Point pointA = points.get(0);
        Point pointB = points.get(1);

        return Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
    }
}
