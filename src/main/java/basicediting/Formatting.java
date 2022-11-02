
package basicediting;

import java.util.Arrays;

public class Formatting {

    public static void main(String[] args) {
        if (args.length >= 10) {
            throw new IllegalArgumentException("Too many args!");
        }
        Arrays.stream(args).sorted().forEach(System.out::println);
    }
}
