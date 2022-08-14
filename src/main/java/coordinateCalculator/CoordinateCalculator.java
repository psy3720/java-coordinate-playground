package coordinateCalculator;

import coordinateCalculator.view.InputView;
import coordinateCalculator.view.ResultView;

public class CoordinateCalculator {
    private static CoordinateCalculator coordinateCalculator;
    private Points points;
    private ResultView resultView;
    private InputView inputView;

    public CoordinateCalculator() {
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
        resultView.print(calculate(inputView.init()), generateFigure());
    }

    public Points calculate(String coordinate) {
        points = new Points(coordinate);
        return points;
    }

    public Figure generateFigure() {
        return points.getFigure();
    }
}
