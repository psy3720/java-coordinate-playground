package coordinateCalculator.model;

public class FigureFactory {
    public static final int LINE_COORDINATE_SIZE = 2;
    public static final int TRIANGLE_COORDINATE_SIZE = 3;
    public static final int RECTANGLE_COORDINATE_SIZE = 4;

    public static Figure create(Points points) {
        if(points.size() == LINE_COORDINATE_SIZE) {
            return new Line(points);
        }

        if(points.size() == TRIANGLE_COORDINATE_SIZE) {
            return new Triangle(points);
        }

        if(points.size() == RECTANGLE_COORDINATE_SIZE) {
            return new Rectangle(points);
        }

        throw new RuntimeException("좌표를 올바르게 입력해주세요");
    }
}
