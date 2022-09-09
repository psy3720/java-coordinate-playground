package coordinateCalculator.model;

import coordinateCalculator.model.Line;
import coordinateCalculator.model.Point;
import coordinateCalculator.model.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(new Points(Arrays.asList(new Point(1, 2), new Point(3, 4))));
    }

    @Test
    public void 선_만들기() {
        Line line = new Line(new Points(Arrays.asList(new Point(10, 10), new Point(14, 15))));
    }

    @Test
    public void 두점사이의_거리() {
        Line line = new Line(new Points(Arrays.asList(new Point(10, 10), new Point(14, 15))));
        assertThat(line.area()).isEqualTo(6.403124, offset(0.00099));
    }
}
