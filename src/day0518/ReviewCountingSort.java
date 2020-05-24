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
        // 记录当前数字有几个的这个数组，长度比array长度多了一个！为什么要多这一个？
        // 因为数组是从零开始的，countArray记录的是array元素的相对位置
        int[] countArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            // 记录的是相对位置
            countArray[array[i] - min]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        // 创建一个新的数组存放排序过后的数组
        int[] sortArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortArray = sort(array);
        System.out.println(Arrays.toString(sortArray));
    }
}
