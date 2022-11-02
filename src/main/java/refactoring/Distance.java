package refactoring;

import static java.lang.Math.sqrt;

public class Distance {

    double distance(int x1, int y1, int x2, int y2) {
        return sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
