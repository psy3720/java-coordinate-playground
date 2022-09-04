package coordinateCalculator.ui;

import coordinateCalculator.model.Figure;
import coordinateCalculator.model.FigureFactory;
import coordinateCalculator.model.Point;
import coordinateCalculator.model.Points;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    Scanner sc;
    Points pointList;

    public InputView() {
        sc = new Scanner(System.in);
        pointList = new Points();
    }

    public Figure init() {
        return FigureFactory.create(input(sc.next()));
    }

    public Points input(String input) {
        validate(input);

        return pointList;
    }

    private void validate(String input) {
        if (null == input || input.isEmpty()) {
            throw new RuntimeException("좌표값을 입력해주세요.");
        }

        String[] split = input.split("-");

        for (String s : split) {
            Point point = matchPattern(s);

            if (pointList.hasPoint(point)) {
                throw new RuntimeException("중복된 값이 존재합니다.");
            }

            pointList.add(point);
        }
    }

    private Point matchPattern(String input) {
        System.out.println("input = " + input);
        String regEx = "\\((\\d{1,2}),(\\d{1,2})\\)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            return new Point(x, y);
        }

        throw new RuntimeException("올바른 좌표값을 입력해주세요.");
    }
}
