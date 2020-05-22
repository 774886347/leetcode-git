package day0518;

import java.util.Arrays;

/**
 * 记录位置的计数排序
 */
public class CountSortRecLocate {
    public static int[] sort(int[] array) {
        // 1.得到数列最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        // 2. 创建统计数组，并统计对应元素的个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        // 3.统计数组做变形，后面的元素等于前面的元素之和(为什么变形的数组能记录元素的准确位置？答因为)
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        // 4.倒序遍历原始数组，从统计数组找到正确位置，输出到结果数组(为什么是倒序遍历，有其他方式遍历吗？)
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
