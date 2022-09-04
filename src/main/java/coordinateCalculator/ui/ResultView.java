package coordinateCalculator.ui;

import coordinateCalculator.model.Point;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static final String LINE_X_MARK = "----";
    public static final String POINT_MARK = ".";
    public static final String LINE_Y_MARK = "|";
    public static final String VERTEX_MARK = "  +";
    public static final String FOUR_BLANK_MARK = "    ";

    public static void main(String[] args) {
        ResultView resultview = new ResultView();
        resultview.init(Arrays.asList(new Point(1, 2), new Point(6, 6)));
    }

    private void init(List<Point> points) {
        printYAxis(points);
        printXAxis();
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

    private void printYAxis(List<Point> points) {
        for (int i = 24; i > 0; i--) {
            int index = i;

            printYAxisNumber(i);
            printDotMark(points, index);
            printEmptyLine();
        }
    }

    private void printDotMark(List<Point> points, int index) {
        points.stream().forEach(point -> {
            if (point.isSameY(index)) {
                printSpace(point.getX());
                printDot();
            }
        });
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

    private void printSpace(int y) {
        for (int j = 0; j < y; j++) {
            System.out.printf(FOUR_BLANK_MARK);
        }
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
