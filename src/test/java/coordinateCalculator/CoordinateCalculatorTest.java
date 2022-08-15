package coordinateCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CoordinateCalculatorTest {
    @Test
    public void createPosition() {
        Point point = new Point(4,5);
        assertThat(point).isEqualTo(new Point(4, 5));
    }

    @Test
    public void position_범위초과또는미만() throws RuntimeException {
        assertThatThrownBy(() -> new Point(-1, 10)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void coordinateCalculator() {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        Points result = coordinateCalculator.calculate("(10,10)-(14,15)");

        assertThat(result.contains(new Point(10,10))).isTrue();
        assertThat(result.contains(new Point(14,15))).isTrue();
    }

    @Test
    public void getDistance() {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        coordinateCalculator.calculate("(10,10)-(14,15)");
        Figure line = coordinateCalculator.generateFigure();
        assertThat(line.getField()).isEqualTo(6.403124, offset(0.00099));
    }

    @Test
    public void isRectangle_fail() throws RuntimeException {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        assertThatThrownBy(() -> coordinateCalculator.calculate("(10,10)-(22,10)-(22,18)-(10,19)")).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void isRectangle_success() throws RuntimeException {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        coordinateCalculator.calculate("(10,10)-(22,10)-(22,18)-(10,18)");
    }

    @Test
    public void rectangleWidth() {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        coordinateCalculator.calculate("(10,10)-(22,10)-(22,18)-(10,18)");
        Square figure = (Square) coordinateCalculator.generateFigure();
        int width = figure.getWidth(new Points("(10,10)-(22,10)-(22,18)-(10,18)"));

        assertThat(width).isEqualTo(12);
    }

    @Test
    public void rectangleHeight() {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        coordinateCalculator.calculate("(10,10)-(22,10)-(22,18)-(10,18)");
        Square figure = (Square) coordinateCalculator.generateFigure();
        int height = figure.getHeight(new Points("(10,10)-(22,10)-(22,18)-(10,18)"));

        assertThat(height).isEqualTo(8);
    }

    @Test
    public void isEqualX() {
        Point point = new Point(1,2);
        assertThat(point.isEqualX(1)).isTrue();
    }

    @Test
    public void isEqualY() {
        Point point = new Point(1,2);
        assertThat(point.isEqualY(2)).isTrue();
    }

    @Test
    public void createTriangle() {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        coordinateCalculator.calculate("(10,10)-(14,15)-(20,8)");
        Triangle triangle = (Triangle) coordinateCalculator.generateFigure();

        assertThat(triangle.getField()).isEqualTo(29);
    }


}
