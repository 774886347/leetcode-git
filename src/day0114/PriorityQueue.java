package day0114;

import java.util.Arrays;

public class PriorityQueue {
    private int[] array;
    private int size;

    public PriorityQueue() {
        array = new int[32];
    }

    public void enQueue(int key) {
        if (size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    public int deQueue() throws Exception {
        int head = array[0];
        if (array.length <= 0) {
            throw new Exception("array is null");
        }
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    public void resize() {
        Arrays.copyOf(this.array, size <<= 1);
    }

    /**
     * 上浮操作，子节点值比父节点大则上浮
     */
    public void upAdjust() {
        int childIndex = this.size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int tmp = array[childIndex];
        while (childIndex > 0 && tmp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = tmp;
    }

    /**
     * 下沉操作,最大堆，父节点值比子节点小则下沉
     */
    public void downAdjust() {

    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue=new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println(Arrays.toString(priorityQueue.array));
    }
}
