package coordinateCalculator.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Rectangle extends FigureAbstract {
    public static final int RECTANGLE_COORDINATE_SIZE = 4;

    public Rectangle(Points points) {
        super(points);
        validate(points);
    }

    private void validate(Points points) {
        if(points.size() != RECTANGLE_COORDINATE_SIZE) {
            throw new RuntimeException("좌표를 올바르게 입력해주세요.");
        }

        if(isRectangle()) {
            throw new RuntimeException("직사각형이 아닙니다..");
        }
    }

    private boolean isRectangle() {
        return getSetX().size() != 2 || getSetY().size() != 2;
    }

    private Set<Integer> getSetX() {
        Set<Integer> setX = new HashSet<>();
        
        for(int i = 0; i< points.size(); i++) {
            setX.add(points.get(i).getX());
        }
        
        return setX;
    }    
    
    private Set<Integer> getSetY() {
        Set<Integer> setY = new HashSet<>();
        
        for(int i = 0; i< points.size(); i++) {
            setY.add(points.get(i).getY());
        }
        
        return setY;
    }

    @Override
    public Double area() {
        Set<Integer> setX = getSetX();
        Set<Integer> setY = getSetY();

        int width = Collections.max(setX) - Collections.min(setX);
        int height = Collections.max(setY) - Collections.min(setY);

        return (double) width * height;
    }

    @Override
    public String getAreaInfo() {
        return "사각형 넓이는 " + area();
    }
}
