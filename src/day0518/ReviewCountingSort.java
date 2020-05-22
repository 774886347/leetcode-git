package day0518;

import java.util.Arrays;

public class ReviewCountingSort {
    public static int[] sort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        int d = max - min;
        int[] countArray = new int[array.length + 1];
        for (int value : array) {
            countArray[value - d + 1]++;
        }
        for (int i = 1; i <= countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        for (int i = array.length; i >= 0; i--) {
            array[countArray[i]] = array.length + d;
            countArray[i]--;
        }
        return countArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortArray = sort(array);
        System.out.println(Arrays.toString(sortArray));
    }
}
