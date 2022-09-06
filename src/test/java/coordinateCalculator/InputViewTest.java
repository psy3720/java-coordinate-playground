package coordinateCalculator;

import coordinateCalculator.model.Line;
import coordinateCalculator.model.FigureFactory;
import coordinateCalculator.model.Rectangle;
import coordinateCalculator.model.Triangle;
import coordinateCalculator.ui.InputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @Test
    void 올바른값_입력() {
        InputView inputView = new InputView();
        inputView.input("(1,2)-(3,4)");
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
