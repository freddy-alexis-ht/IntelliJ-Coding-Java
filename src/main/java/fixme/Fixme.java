package fixme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Fixme {

    private final int rangeEnd;

    private final ArrayList<String> list = new ArrayList<>(10);

    public Fixme(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    int[] highestBits() {
        return IntStream.range(0, this.rangeEnd).map(Integer::highestOneBit).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Fixme(100).highestBits()));
    }
}
