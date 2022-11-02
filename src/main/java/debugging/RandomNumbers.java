package debugging;

import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbers {

    public static void main(String[] args) {
        String collected = new Random().ints(0, 99).limit(15)
                .sorted()
                .mapToObj(String::valueOf)
                .filter(n -> !n.startsWith("7"))
                .collect(Collectors.joining(", "));
        System.out.println(collected);
    }

}
