package coordinateCalculator.model;

import java.util.Objects;

public class Point {
    private static final int POINT_VALUE_MIN = 0;
    private static final int POINT_VALUE_MAX = 24;
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSameX(int x) {
        return this.x == x;
    }

    public boolean isSameY(int y) {
        return this.y == y;
    }

    public Point(int x, int y) {
        validate(x, y);

        this.x = x;
        this.y = y;
    }

    private void validate(int x, int y) {
        if(x > POINT_VALUE_MAX || x < POINT_VALUE_MIN) {
            throw new RuntimeException("X 좌표는 0부터 최대 24까지 입력 가능합니다.");
        }

        if(y > POINT_VALUE_MAX || y < POINT_VALUE_MIN) {
            throw new RuntimeException("Y 좌표는 0부터 최대 24까지 입력 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
