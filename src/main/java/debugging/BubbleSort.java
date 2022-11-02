package debugging;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        System.out.println("Input:\t" + Arrays.toString(array));
        sort(array);
        System.out.println("Sorted:\t" + Arrays.toString(array));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j);
                }
            }
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j];
        arr[j + 1] = temp;
    }
}
