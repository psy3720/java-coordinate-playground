package coordinateCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    @BeforeEach
    void create() {

    }

    @Test
    public void 선_만들기() {
        Line line = new Line("(10,10)-(14,15)");
    }

    @Test
    public void 범위초과() {
//        Assertions.assertThatThrownBy(() -> new Line("(25,10)-(2,23)")).isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Line("(25,10)-(5,-23)")).isInstanceOf(RuntimeException.class);

    }

    @Test
    public void 좌표값비교() {
        Line line = new Line("(10,10)-(14,15)");
        assertThat(line.hasPoints(Arrays.asList(new Point(10,10), new Point(13,15)))).isFalse();
    }

    @Test
    public void 두점사이의_거리() {
        Line line = new Line("(10,10)-(14,15)");
        assertThat(line.length()).isEqualTo(6.403124, offset(0.00099));
    }
}
