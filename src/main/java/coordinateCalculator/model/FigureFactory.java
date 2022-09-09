package coordinateCalculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory  {
    public static final int LINE_COORDINATE_SIZE = 2;
    public static final int TRIANGLE_COORDINATE_SIZE = 3;
    public static final int RECTANGLE_COORDINATE_SIZE = 4;
    static Map<Integer, Function<Points, Figure>> function = new HashMap<>();

    static {
        function.put(LINE_COORDINATE_SIZE, Line::new);
        function.put(TRIANGLE_COORDINATE_SIZE, Triangle::new);
        function.put(RECTANGLE_COORDINATE_SIZE, Rectangle::new);
    }

    public static Figure create(Points points) {
        if(null == points) {
            throw new RuntimeException("좌표값을 입력해주세요.");
        }

        if(isValidateNumber(points)) {
            throw new RuntimeException("좌표값을 올바르게 입력해주세요.");
        };

        return function.get(points.size()).apply(points);
    }

    private static boolean isValidateNumber(Points points) {
        int size = points.size();

        return size < LINE_COORDINATE_SIZE  || RECTANGLE_COORDINATE_SIZE < size;
    }
}
