package coordinateCalculator.model;

import java.util.Objects;

public abstract class FigureAbstract implements Figure {
    Points points;

    public FigureAbstract(Points points) {
        if(null == points || points.isEmpty()) {
            throw new RuntimeException("올바른 포인트값을 입력해주세요.");
        }

        this.points = points;
    }

    @Override
    public Points getPoints() {
        return points;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FigureAbstract that = (FigureAbstract) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
