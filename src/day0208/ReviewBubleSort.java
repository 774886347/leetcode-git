package day0208;

import java.util.Arrays;

/**
 * @author Wings
 */
public class ReviewBubleSort {
    public static void oldSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * 优化1：用一个标志位记录数组的状态，若待交换的数列没有元素交换，则代表数列已经有序，直接结束循环
     *
     * @param array
     */
    public static void optimizedSort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 优化2：记录有序边界位置，交换的位置为有序的边界
     *
     * @param array
     */
    public static void optimizedSort2(int[] array) {
        int lastExchangeIndex = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    lastExchangeIndex = j;
                    isSort = false;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 优化3：鸡尾酒排序，一左一右
     *
     * @param array
     */
    public static void cocktailSort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSort = true;
            // 奇数轮
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
            // 偶数轮，将isSort变为true
            isSort = true;
            for (int k = array.length - 1 - i; k > i; k--) {
                if (array[k] < array[k - 1]) {
                    tmp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = tmp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序针对有序区域的优化
     *
     * @param array
     */
    public static void cockteilOptimizedSort(int[] array) {
        int tmp = 0;
        int lastExchangeIndex = 0;
        int sortBorderRight = 0;
        int sortBorderLeft = array.length - 1;
        boolean isSort1 = true;
        boolean isSort2 = true;
        for (int i = 0; i < array.length / 2; i++) {
            // 奇数轮
            isSort1 = true;
            for (int j = sortBorderRight; j < sortBorderLeft; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    lastExchangeIndex = j;
                    isSort1 = false;
                }
            }
            if (isSort1) {
                break;
            }
            sortBorderLeft = lastExchangeIndex;
            // 偶数轮，将isSort变为true
            isSort2 = true;
            for (int k = sortBorderLeft; k > sortBorderRight; k--) {
                if (array[k] < array[k - 1]) {
                    tmp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = tmp;
                    lastExchangeIndex = k;
                    isSort2 = false;
                }
            }
            if (isSort2) {
                break;
            }
            sortBorderRight = lastExchangeIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
//        oldSort(array);
//        optimizedSort1(array);
//        optimizedSort2(array);
//        cocktailSort(array);
        cockteilOptimizedSort(array);
        System.out.println(Arrays.toString(array));
    }
}
