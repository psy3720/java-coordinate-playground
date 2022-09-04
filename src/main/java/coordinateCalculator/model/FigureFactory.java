package coordinateCalculator.model;

public class FigureFactory {
    public static Figure create(Points points) {
        if(points.size() == 2) {
            return new Line(points);
        }

        if(points.size() == 4) {
            return new Rectangle(points);
        }

        throw new RuntimeException("좌표를 올바르게 입력해주세요");
    }
}
