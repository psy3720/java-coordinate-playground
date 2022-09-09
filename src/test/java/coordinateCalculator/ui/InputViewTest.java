package coordinateCalculator.ui;

import coordinateCalculator.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {


    @Test
    void 올바른값_입력_Line() {
        InputView inputView = new InputView();
        Figure figure = FigureFactory.create(inputView.input("(1,2)-(3,4)"));
        Figure figure1 = FigureFactory.create(new Points(Arrays.asList(new Point(1, 2), new Point(3, 4))));

        assertThat(figure).isEqualTo(figure1);
    }

    @Test
    void 올바른값_입력_Triangle() {
        InputView inputView = new InputView();
        Figure figure = FigureFactory.create(inputView.input("(1,1)-(3,2)-(2,5)"));
        Figure figure1 = FigureFactory.create(new Points(Arrays
                .asList(new Point(1, 1), new Point(3, 2), new Point(2,5))));

        assertThat(figure).isEqualTo(figure1);
    }

    @Test
    void 올바른값_입력_Rectangle() {
        InputView inputView = new InputView();
        Figure figure = FigureFactory.create(inputView.input("(1,5)-(3,5)-(1,3)-(3,3)"));
        Figure figure1 = FigureFactory.create(new Points(Arrays
                .asList(new Point(1, 5), new Point(3, 5), new Point(1,3), new Point(3,3))));

        assertThat(figure).isEqualTo(figure1);
    }



    @Test
    void null_또는_Empty값_입력() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.input("")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> inputView.input(null)).isInstanceOf(RuntimeException.class);
    }
    @Test
    void 올바르지않은_패턴값입력() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.input("(1,2-(3,4)")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> inputView.input("(1,2)-(,4)")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> inputView.input("(1,2)-3,4)")).isInstanceOf(RuntimeException.class);
    }
    @Test
    void 중복된_포인트값_입력() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.input("(1,2)-(1,2)")).isInstanceOf(RuntimeException.class);
    }




}
