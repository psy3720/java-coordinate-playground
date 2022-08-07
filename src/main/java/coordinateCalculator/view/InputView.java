package coordinateCalculator.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String init() {
        System.out.println("좌표를 입력하세요.");
        return scanner.next();
    }
}
