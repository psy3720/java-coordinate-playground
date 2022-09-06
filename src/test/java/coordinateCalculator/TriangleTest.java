package coordinateCalculator;

import coordinateCalculator.model.Point;
import coordinateCalculator.model.Points;
import coordinateCalculator.model.Triangle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TriangleTest {

    @Test
    void 삼각형_넓이() {
        Triangle triangle = new Triangle(new Points(Arrays.asList(new Point(10, 10)
                , new Point(14, 15), new Point(20, 8))));
        Assertions.assertThat(triangle.area()).isEqualTo(29);
    }
}
