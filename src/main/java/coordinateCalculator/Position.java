package coordinateCalculator;

import java.util.Objects;

public class Position {
    private final int POSITION_X_MAX = 24;
    private final int POSITION_X_MIN = 0;
    private final int POSITION_Y_MAX = 24;
    private final int POSITION_Y_MIN = 0;
    private int x;
    private int y;

    public Position(int x, int y) {
        validate(x,y);

        this.x = x;
        this.y = y;
    }

    private void validate(int x, int y) {
        if(x > POSITION_X_MAX || x < POSITION_X_MIN) {
            throw new RuntimeException();
        }

        if(y > POSITION_Y_MAX || y < POSITION_Y_MIN) {
            throw new RuntimeException();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
