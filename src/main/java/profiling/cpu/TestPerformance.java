package profiling.cpu;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestPerformance {

    public static final int ITERATIONS = 100000;

    public static void main(String[] args) {
        warmup();
        testLong();
        testBigDecimal();
    }

    public static void warmup() {
        long start = System.nanoTime();
        LongAccount account = new LongAccount();
        account.credit(1022);
        account.deposit(2025);
        BigDecimalAccount bigDecimalAccount = new BigDecimalAccount();
        bigDecimalAccount.credit(BigDecimal.valueOf(10.22));
        bigDecimalAccount.deposit(BigDecimal.valueOf(20.25));
        printDurationNanos(start);

    }

    public static void testLong() {
        long start = System.nanoTime();
        LongAccount account = new LongAccount();
        for (int i = 0; i < ITERATIONS; i++) {
            account.credit(1022);
            account.deposit(2025);
        }
        printDurationNanos(start);
    }

    public static void testBigDecimal() {
        long start = System.nanoTime();
        BigDecimalAccount account = new BigDecimalAccount();
        for (int i = 0; i < ITERATIONS; i++) {
            account.credit(BigDecimal.valueOf(10.22));
            account.deposit(BigDecimal.valueOf(20.25));
        }
        printDurationNanos(start);
    }

    private static void printDurationNanos(long start) {
        System.out.println(new DecimalFormat("completed in ###,###,### ns").format(System.nanoTime() - start));
    }
}
