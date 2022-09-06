package coordinateCalculator.ui;

import coordinateCalculator.model.Figure;
import coordinateCalculator.model.Point;
import coordinateCalculator.model.Points;

public class ResultView {
    public static final String LINE_X_MARK = "----";
    public static final String POINT_MARK = ".";
    public static final String LINE_Y_MARK = "|";
    public static final String VERTEX_MARK = "  +";
    public static final String FOUR_BLANK_MARK = "    ";

    public void init(Figure figure) {
        printYAxis(figure.getPoints());
        printXAxis();
        printAreaInfo(figure);
    }

    private void printAreaInfo(Figure figure) {
        printEmptyLine();
        System.out.println(figure.getAreaInfo());
    }

    private void printYAxis(Points points) {
        for (int i = 24; i > 0; i--) {
            int index = i;

            printYAxisNumber(i);
            printDotMark(points, index);
            printEmptyLine();
        }
    }

    private void printDotMark(Points points, int index) {
        for(int i=1; i<=24; i++) {
            if(points.hasPoint(new Point(i, index))) {
                printDot();
                continue;
            }
            printSpace();
        }
    }

    private void printXAxis() {
        System.out.printf(VERTEX_MARK);

        for (int i = 1; i <= 24; i++) {
            System.out.printf(LINE_X_MARK);
        }
        printEmptyLine();

        for (int i = 0; i <= 24; i++) {
            printXAxisNumber(i);
        }
    }

    private void printXAxisNumber(int i) {
        if (i % 2 == 0) {
            System.out.printf("%4d", i);
            return;
        }
        System.out.printf(FOUR_BLANK_MARK);
    }

    private void printYAxisNumber(int i) {
        if (i % 2 == 0) {
            System.out.printf("%2d" + LINE_Y_MARK, i);
            return;
        }
        System.out.printf("  " + LINE_Y_MARK);
    }

    private void printDot() {
        System.out.printf(POINT_MARK);
    }

    private void printSpace() {
        System.out.printf(FOUR_BLANK_MARK);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
