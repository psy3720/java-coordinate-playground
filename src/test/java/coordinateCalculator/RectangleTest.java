package coordinateCalculator;

import coordinateCalculator.model.Point;
import coordinateCalculator.model.Points;
import coordinateCalculator.model.Rectangle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RectangleTest {
    @Test
    void invalid_직사각형() {
        Assertions.assertThatThrownBy(() -> new Rectangle(new Points(Arrays.asList(new Point(10, 10)
                , new Point(22, 10)
                , new Point(22, 18)
                , new Point(10, 12)
        )))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void createRectangle() {
        Rectangle rectangle = new Rectangle(new Points(Arrays.asList(new Point(10,10)
                , new Point(22,10)
                , new Point(22, 18)
                , new Point(10, 18)
        )));

        Assertions.assertThat(rectangle.area()).isEqualTo(96);
    }


}
