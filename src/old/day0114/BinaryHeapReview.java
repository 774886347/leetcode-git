package old.day0114;

import java.util.Arrays;

public class BinaryHeapReview {
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        // tmp 保存插入的叶子结点的值，用于最后的赋值
        int tmp = array[childIndex];
        while (childIndex > 0 && tmp < array[parentIndex]) {
            // 无需真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = tmp;
    }
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // tmp 保存父节点值，用于最后的赋值
        int tmp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小於左孩子的值，則定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父節點小於任何一個孩子的值，則直接跳出
            if (tmp <= array[childIndex]) {
                break;
            }
            // 無需真正交換，單向賦值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = tmp;
    }
    // 构建堆
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次做下沉操作调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
