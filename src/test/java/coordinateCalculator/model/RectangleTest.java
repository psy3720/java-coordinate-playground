package coordinateCalculator.model;

import coordinateCalculator.model.Point;
import coordinateCalculator.model.Points;
import coordinateCalculator.model.Rectangle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {
    @Test
    void 직사각형_생성() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1)
                , new Point(1, 15)
                , new Point(3, 1)
                , new Point(3, 15)));

        Rectangle rectangle = new Rectangle(points);
        assertThat(rectangle).isEqualTo(new Rectangle(points));
    }

    @Test
    void 직사각형_생성_오류() {
        assertThatThrownBy(() -> new Rectangle(new Points(Arrays.asList(new Point(10, 10)
                , new Point(22, 10)
                , new Point(22, 18)
                , new Point(10, 12)
        )))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 직사각형_넓이계산() {
        Rectangle rectangle = new Rectangle(new Points(Arrays.asList(new Point(10,10)
                , new Point(22,10)
                , new Point(22, 18)
                , new Point(10, 18)
        )));

        assertThat(rectangle.area()).isEqualTo(96);
    }


}
