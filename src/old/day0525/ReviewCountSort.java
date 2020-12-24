package old.day0525;

import java.util.Arrays;

public class ReviewCountSort {
    public static int[] sort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] countArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] sortArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
