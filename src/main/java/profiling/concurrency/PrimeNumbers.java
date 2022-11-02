package profiling.concurrency;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class PrimeNumbers {

    public static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= (number / 2); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] calcPrimes(int stepSize) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        //ExecutorService executor = Executors.newFixedThreadPool(3);
        Collection<Future<int[]>> results = new ArrayList<>();
        for (int i = 1; i < 600_000; i += stepSize) {
            results.add(submitTask(executor, i, i + stepSize));
        }
        executor.shutdown();
        //noinspection ResultOfMethodCallIgnored
        executor.awaitTermination(10, TimeUnit.MINUTES);
        return results.stream().flatMapToInt(future -> {
            try {
                return IntStream.of(future.get());
            } catch (InterruptedException | ExecutionException e) {
                return IntStream.empty();
            }
        }).toArray();
    }

    @NotNull
    private static Future<int[]> submitTask(ExecutorService executor, int start, int end) {
        return executor.submit(() -> {
            System.out.printf("Calculating primes %d to %d on thread %s\n", start, end, Thread.currentThread());
            return IntStream.range(start, end).filter(PrimeNumbers::isPrimeNumber).toArray();
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        int[] primes = calcPrimes(50000);
        long duration = System.currentTimeMillis() - start;
        System.out.println(Arrays.toString(primes));
        System.out.printf("Calculation took %d ms", duration);
    }
}
