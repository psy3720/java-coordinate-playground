package coordinateCalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {

    @Test
    void 포인트_생성() {
        assertThat(new Point(1, 2)).isEqualTo(new Point(1, 2));
    }

    @Test
    void 좌표의_범위를_넘어가는_값이_생성자에_입력되었을_경우() {
        assertThatThrownBy(() -> new Point(0, 1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Point(1, 25)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Point(1, 0)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Point(25, 1)).isInstanceOf(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> {
            new Point(1, 25);
        });

        assertThrows(RuntimeException.class, () -> {
            new Point(0, 24);
        });
    }

    @Test
    void 주어진_좌표와_포인트를_비교() {
        assertThat(new Point(1,2).isSameX(1)).isTrue();
        assertThat(new Point(1,2).isSameY(2)).isTrue();
        assertThat(new Point(1,2).isSameX(2)).isFalse();
        assertThat(new Point(1,2).isSameY(1)).isFalse();
    }
}
