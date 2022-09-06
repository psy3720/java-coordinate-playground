package coordinateCalculator.model;

import java.util.Arrays;

public class Triangle extends FigureAbstract{
    private static final int TRIANGLE_COORDINATE_SIZE = 3;

    public Triangle(Points points) {
        super(points);
        validate(points);
    }

    private void validate(Points points) {
        if(points.size() != TRIANGLE_COORDINATE_SIZE) {
            throw new RuntimeException("올바른 좌표를 입력해주세요.");
        }
    }

    @Override
    public Double area() {
        Line lineA = new Line(new Points(Arrays.asList(points.get(0), points.get(1))));
        Line lineB = new Line(new Points(Arrays.asList(points.get(1), points.get(2))));
        Line lineC = new Line(new Points(Arrays.asList(points.get(2), points.get(0))));

        double a = lineA.length();
        double b = lineB.length();
        double c = lineC.length();

        Double s = (a + b + c) / 2;
        Double S = Math.sqrt(s*(s-a)*(s-b)*(s-c));

        return Double.valueOf(Math.round(S));
    }

    @Override
    public String getAreaInfo() {
        return "삼각형 넓이는 " + area();
    }
}
