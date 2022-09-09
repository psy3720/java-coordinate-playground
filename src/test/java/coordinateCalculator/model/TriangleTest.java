package coordinateCalculator.model;

import coordinateCalculator.model.Point;
import coordinateCalculator.model.Points;
import coordinateCalculator.model.Triangle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    @Test
    void 삼각형_생성() {
        List<Point> points = Arrays.asList(new Point(1, 1), new Point(2, 10), new Point(7, 5));
        Triangle triangle = new Triangle(new Points(points));

        assertThat(triangle).isEqualTo(new Triangle(new Points(points)));
    }


    @Test
    void 삼각형_넓이계산() {
        Triangle triangle = new Triangle(new Points(Arrays.asList(new Point(10, 10)
                , new Point(14, 15), new Point(20, 8))));
        assertThat(triangle.area()).isEqualTo(29);
    }

    @Test
    void 삼각형_유효성체크() {
//        Assertions.assertThatThrownBy(() -> new Triangle(new Points(Arrays.asList(new Point(5, 10),
//                new Point(10, 10), new Point(6, 10))))).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Triangle(
                new Points(Arrays.asList(
                        new Point(1, 1), new Point(2, 2), new Point(3, 3)))))
                .isInstanceOf(RuntimeException.class);
    }


}
