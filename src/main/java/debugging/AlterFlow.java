package debugging;

import java.util.Random;

public class AlterFlow {

    public static void main(String[] args) {
        int result = start(10);
        System.out.println(result);
    }

    private static int start(int n) {
        int result;
        try {
            if (new Random().nextBoolean()) {
                result = calculationA(n);
            } else {
                result = calculationB(n);
            }
        } catch (Exception e) {
            result = -1;
        }
        return result;
    }

    private static int calculationB(int n) {
        return n * 2;
    }

    private static int calculationA(int n) {
        return n * n;
    }
}
