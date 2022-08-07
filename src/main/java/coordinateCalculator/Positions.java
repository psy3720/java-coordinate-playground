package coordinateCalculator;

import java.util.ArrayList;
import java.util.List;

public class Positions {
    private List<Position> positions;

    public Positions() {
        this.positions = new ArrayList<>();
    }

    public void add(Position position) {
        positions.add(position);
    }

    public int size() {
        return positions.size();
    }

    public Position get(int i) {
        return positions.get(i);
    }

    public boolean contains(Position position) {
        for(Position p : positions) {
            if(p.equals(position)) {
                return true;
            }
        }

        return false;
    }
}
