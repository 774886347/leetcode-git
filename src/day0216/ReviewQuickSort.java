package day0216;

import java.util.Arrays;

/**
 * @author Wings
 */
public class ReviewQuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            // arr[right] >= pivot -> java.lang.StackOverflowError
            while (left < right && arr[right] > pivot) {
                right--;
            }
            // arr[left] < pivot -> 死循环
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return pivot;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
