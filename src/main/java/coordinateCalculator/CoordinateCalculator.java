package coordinateCalculator;

import coordinateCalculator.view.InputView;
import coordinateCalculator.view.ResultView;

public class CoordinateCalculator {
    private static CoordinateCalculator coordinateCalculator;
    private Positions positions;
    private ResultView resultView;
    private InputView inputView;

    public CoordinateCalculator() {
        positions = new Positions();
        resultView = new ResultView();
        inputView = new InputView();
    }

    public static CoordinateCalculator create() {
        if (null == coordinateCalculator) {
            coordinateCalculator = new CoordinateCalculator();
        }
        return coordinateCalculator;
    }

    public void init() {
        this.calculate(inputView.init());
        resultView.print(positions, generateLine());
    }

    public Positions calculate(String coordinate) {
        String[] split = coordinate.split("-");

        for (String s : split) {
            s = s.replace("(", "").replace(")", "");

            String[] split1 = s.split(",");
            int x = Integer.parseInt(split1[0]);
            int y = Integer.parseInt(split1[1]);
            positions.add(new Position(x, y));
        }

        return positions;
    }

    public Line generateLine() {
        return new Line(positions);
    }
}
