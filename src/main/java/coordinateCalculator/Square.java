package coordinateCalculator;

public class Square extends Figure {
    Points points;

    public Square(Points points) {
        validate(points);
        this.points = points;
    }

    private void validate(Points points) {
        if(points.size() != 4) {
            throw new RuntimeException();
        }

        for(int i=0; i< points.size(); i++) {
            Point point = points.get(i);
            int x = point.getX();
            int y = point.getY();

            int countX = 0;
            int countY = 0;

            for(int j=0; j< points.size(); j++) {
                Point point1 = points.get(j);
                if(x == point1.getX()) {
                    countX++;
                }

                if(y == point1.getY()) {
                    countY++;
                }
            }

            if(countX != 2 || countY != 2) {
                throw new RuntimeException();
            }
        }
    }

    // 면적계산
    public double getField() {
        return getHeight(points) * getWidth(points);
    }

    public int getWidth(Points points) {
        int width = 1;

        for(int i=0; i< points.size(); i++) {
            Point point = points.get(i);
            int x = point.getX();

            for(int j=i+1; j< points.size(); j++) {
                Point point1 = points.get(j);
                int point1X = point1.getX();

                if(point1X != x) {
                    width = Math.abs(point1X - x);
                }
            }
        }
        return width;
    }

    public int getHeight(Points points) {
        int height = 1;

        for(int i = 0; i< this.points.size(); i++) {
            Point point = this.points.get(i);
            int y = point.getY();

            for(int j = i+1; j< this.points.size(); j++) {
                Point point1 = this.points.get(j);
                int point1Y = point1.getY();

                if(point1Y != y) {
                    height = Math.abs(point1Y - y);
                }
            }
        }
        return height;
    }

    public String getFigure() {
        return "사각형 넓이는 ";
    }
}
