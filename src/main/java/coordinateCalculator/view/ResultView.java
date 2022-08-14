package coordinateCalculator.view;

import coordinateCalculator.Figure;
import coordinateCalculator.Line;
import coordinateCalculator.Point;
import coordinateCalculator.Points;

public class ResultView {
    private static String SPECIAL_CHARACTER = " ● ";
    private static final int Y_COORDINATE_MAX = 24;
    private static final int X_COORNIDATE_MAX = 24;

    private static boolean isPrintCharacter(int x, int y, Points points) {
        if(points.contains(new Point(x,y))) {
            return true;
        }
        return false;
    }

    private static void printYline(int i) {
        if (i % 2 == 0) {
            System.out.printf("%2d|", (i));
        } else {
            System.out.printf("  |");
        }
    }

    private static void printXline() {
        System.out.print("  +");
        for (int i = 0; i < X_COORNIDATE_MAX; i++) {
            System.out.print("---");
        }
        System.out.println();
        for (int i = 0; i <= X_COORNIDATE_MAX; i++) {
            if (i % 2 == 0) {
                System.out.printf("%2d", i);
            } else {
                System.out.print("　 ");
            }
        }
    }

    public void print(Points points, Figure figure) {
        for (int y = Y_COORDINATE_MAX; y > 0; y--) {
            printYline(y);

            for (int x = 0; x < X_COORNIDATE_MAX; x++) {
                if (isPrintCharacter(x, y, points)) {
                    System.out.printf(SPECIAL_CHARACTER);
                } else {
                    System.out.printf("  ");
                }
            }
            System.out.println();
        }
        printXline();
        System.out.println();
        System.out.println(figure.getFigure() + figure.getField());
    }
}
