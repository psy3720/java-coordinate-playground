package coordinateCalculator.model;

public class Line extends FigureAbstract {
    private static final int LINE_COORDINATE_SIZE = 2;

    public Line(Points points) {
        super(points);
        validate();
    }

    private void validate() {
        if(points.size() != LINE_COORDINATE_SIZE) {
            throw new RuntimeException("좌표를 올바르게 입력해주세요.");
        }
    }

    public Double length() {
        Point pointA = points.get(0);
        Point pointB = points.get(1);

        return Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
    }

    @Override
    public String getAreaInfo() {
        return "두 점 사이의 거리는 " + length();
    }
}
