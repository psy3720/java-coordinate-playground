package coordinateCalculator;

import coordinateCalculator.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CoordinateCalculator {
    private static CoordinateCalculator coordinateCalculator;
    List<Position> positions;
    private ResultView resultView;

    public CoordinateCalculator() {
        this.positions = new ArrayList<>();
        resultView = new ResultView();
    }

    public static CoordinateCalculator create() {
        if(null == coordinateCalculator) {
            coordinateCalculator = new CoordinateCalculator();
        }
        return coordinateCalculator;
    }

    public List<Position> calculate(String coordinate) {
        String[] split = coordinate.split("-");

        for(String s : split) {
            s = s.replace("(", "").replace(")", "");

            String[] split1 = s.split(",");
            int x = Integer.parseInt(split1[0]);
            int y = Integer.parseInt(split1[1]);
            positions.add(new Position(x, y));
        }

        return positions;
    }

    public void print() {
        resultView.print(positions);
    }

    public double getDistance() {
        if(positions.size() == 2) {
            Position positionA = positions.get(0);
            Position positionB = positions.get(1);
            double powX = Math.pow(positionA.getX() - positionB.getX(), 2);
            double powY = Math.pow(positionA.getY() - positionB.getY(), 2);
            return Math.sqrt(powX +powY);
        }
        return 0;
    }
}
