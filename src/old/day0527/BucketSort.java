package old.day0527;

import java.util.*;

/**
 * 桶排序
 */
public class BucketSort {
    public static double[] bucketSort(double[] array) {
        double min = array[0];
        double max = array[0];
        // 找到最小值和最大值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;
        // 桶数量
        int bucketNum = array.length;
        List<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        // 初始化桶
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }
        // 把元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        for(int i = 0; i < bucketList.size(); i++){
            //JDK底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }

        double[] sortedArray = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList){
            for(double element : list){
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
