package coordinateCalculator;

import java.util.Objects;

public class Point {
    private final int MAX_VALUE = 24;
    private final int MIN_VALUE = 0;
    private int x;
    private int y;

    public Point(int x, int y) {
        validate(x,y);

        this.x = x;
        this.y = y;
    }

    private void validate(int x, int y) {
        if(x > MAX_VALUE || x < MIN_VALUE) {
            throw new RuntimeException();
        }

        if(y > MAX_VALUE || y < MIN_VALUE) {
            throw new RuntimeException();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEqualX(int x) {
        return this.x == x;
    }

    public boolean isEqualY(int y) {
        return this.y == y;
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
