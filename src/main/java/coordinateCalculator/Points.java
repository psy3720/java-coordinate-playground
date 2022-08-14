package coordinateCalculator;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private List<Point> points;
    Figure figure;

    public Points(String coordinate) {
        this.points = new ArrayList<>();
        String[] split = coordinate.split("-");

        for (String s : split) {
            s = s.replace("(", "").replace(")", "");

            String[] split1 = s.split(",");
            int x = Integer.parseInt(split1[0]);
            int y = Integer.parseInt(split1[1]);
            points.add(new Point(x, y));
        }
        this.validate(split);
    }

    private void validate(String[] split) {
        int length = split.length;

        if(length == 2) {
           figure = new Line(this);
        }

        if(length == 4) {
            figure = new Square(this);
        }
    }

    public int size() {
        return points.size();
    }

    public Point get(int i) {
        return points.get(i);
    }

    public boolean contains(Point point) {
        for(Point p : points) {
            if(p.equals(point)) {
                return true;
            }
        }

        return false;
    }

    public Figure getFigure() {
        return figure;
    }
}
