package coordinateCalculator;

public class Square extends Figure {
    Points points;

    public Square(Points points) {
        validate(points);
        this.points = points;
    }

    private void validate(Points points) {
        if (points.size() != 4) {
            throw new RuntimeException();
        }

        for (int i = 0; i < points.size(); i++) {
            isRectangle(i,points);
        }
    }

    private void isRectangle(int i, Points points) {
        Point point = points.get(i);

        if (countX(point.getX(), points) != 2 || countY(point.getY(), points) != 2) {
            throw new RuntimeException();
        }
    }

    private int countX(int x, Points points) {
        int countX = 0;

        for (int j = 0; j < points.size(); j++) {
            Point point1 = points.get(j);
            if (point1.isEqualX(x)) {
                countX++;
            }
        }
        return countX;
    }

    private int countY(int y, Points points) {
        int countY = 0;

        for (int j = 0; j < points.size(); j++) {
            Point point1 = points.get(j);

            if (point1.isEqualY(y)) {
                countY++;
            }
        }
        return countY;
    }

    // 면적계산
    public double getField() {
        return getHeight(points) * getWidth(points);
    }

    public int getWidth(Points points) {
        int width = 1;

        Point point1 = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point point2 = points.get(i);

            if (!point1.isEqualX(point2.getX())) {
                width = Math.abs(point1.getX() - point2.getX());
                break;
            }
        }
        return width;
    }

    public int getHeight(Points points) {
        int height = 1;

        Point point1 = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point point2 = points.get(i);

            if (!point1.isEqualY(point2.getY())) {
                height = Math.abs(point1.getY() - point2.getY());
                break;
            }
        }
        return height;
    }

    public String getFigure() {
        return "사각형 넓이는 ";
    }
}
