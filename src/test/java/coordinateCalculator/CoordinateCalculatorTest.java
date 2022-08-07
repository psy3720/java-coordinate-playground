package coordinateCalculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CoordinateCalculatorTest {
    @Test
    public void createPosition() {
        Position position = new Position(4,5);
        assertThat(position).isEqualTo(new Position(4, 5));
    }

    @Test
    public void position_범위초과또는미만() throws RuntimeException {
        assertThatThrownBy(() -> new Position(-1, 10)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void coordinateCalculator() {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        Positions result = coordinateCalculator.calculate("(10,10)-(14,15)");

        assertThat(result.contains(new Position(10,10))).isTrue();
        assertThat(result.contains(new Position(14,15))).isTrue();
    }

    @Test
    public void getDistance() {
        CoordinateCalculator coordinateCalculator = CoordinateCalculator.create();
        coordinateCalculator.calculate("(10,10)-(14,15)");
        Line line = coordinateCalculator.createLine();
        assertThat(line.length()).isEqualTo(6.403124, offset(0.00099));
    }
}
