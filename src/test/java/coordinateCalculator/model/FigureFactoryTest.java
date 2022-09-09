package coordinateCalculator.model;

import coordinateCalculator.ui.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FigureFactoryTest {

    @Test
    void null_입력에_대한_예외처리() {
        assertThrows(RuntimeException.class, () -> {
            FigureFactory.create(null);
        });
    }

    @Test
    void Point_1개_입력에_대한_예외처리() {
        assertThrows(RuntimeException.class, () -> {
            FigureFactory.create(new Points(Arrays.asList(new Point(1, 2))));
        });
    }

    @Test
    void Point_5개_이상_입력에_대한_예외처리() {
        assertThrows(RuntimeException.class, () -> {
            FigureFactory.create(new Points(Arrays.asList(
                    new Point(1, 2),
                    new Point(3, 5),
                    new Point(5, 6),
                    new Point(7, 9),
                    new Point(11, 13)
            )));
        });
    }


    @Test
    void Line_클래스_반환() {
        InputView inputView = new InputView();
        assertThat(FigureFactory.create(inputView.input("(1,2)-(3,4)"))).isInstanceOf(Line.class);
    }

    @Test
    void Triangle_클래스_반환() {
        InputView inputView = new InputView();
        assertThat(FigureFactory.create(inputView.input("(10,10)-(14,15)-(20,8)"))).isInstanceOf(Triangle.class);
    }

    @Test
    void Rectangle_클래스_반환() {
        InputView inputView = new InputView();
        assertThat(FigureFactory.create(inputView.input("(10,10)-(22,10)-(22,18)-(10,18)")))
                .isInstanceOf(Rectangle.class);
    }
}
