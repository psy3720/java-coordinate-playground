package coordinateCalculator.model;

import java.util.Arrays;

public class Triangle extends FigureAbstract{
    public Triangle(Points points) {
        super(points);
        validate(points);
    }

    private void validate(Points points) {
        if(isStraightLine(points)) {
            throw new RuntimeException("삼각형이 아닙니다");
        }
    }

    private boolean isStraightLine(Points points) {
        return points.get(0).calculateSlope(points.get(1)) == points.get(0).calculateSlope(points.get(2));
    }

    @Override
    public Double area() {
        Line lineA = new Line(new Points(Arrays.asList(points.get(0), points.get(1))));
        Line lineB = new Line(new Points(Arrays.asList(points.get(1), points.get(2))));
        Line lineC = new Line(new Points(Arrays.asList(points.get(2), points.get(0))));

        double a = lineA.area();
        double b = lineB.area();
        double c = lineC.area();

        Double s = (a + b + c) / 2;
        Double S = Math.sqrt(s*(s-a)*(s-b)*(s-c));

        return Double.valueOf(Math.round(S));
    }

    @Override
    public String getAreaInfo() {
        return "삼각형 넓이는 " + area();
    }
}
