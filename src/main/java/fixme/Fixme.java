package fixme;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Fixme {

    private int rangeEnd;

    private final ArrayList<String> list = new ArrayList(10);

    public Fixme(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    int[] highestBits() {
        return IntStream.range(0, this.rangeEnd).map(operand -> Integer.highestOneBit(operand)).toArray();
    }

    public static void main(String[] args) {
        System.out.println(new Fixme(100).highestBits());
    }
}
