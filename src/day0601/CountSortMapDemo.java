package day0601;

import java.util.*;

public class CountSortMapDemo {
    Map<Integer, Integer> map = new TreeMap<>();

    public void sortMap(Map<Integer, Integer> map) {
        // 对value进行排序
        List<Integer> mapValueList = new ArrayList<>(map.values());
        // 1.得到数列最大值和最小值
        int max = mapValueList.get(0);
        int min = mapValueList.get(0);
        for (int i = 1; i < mapValueList.size(); i++) {
            if (mapValueList.get(i) > max) {
                max = mapValueList.get(i);
            }
            if (mapValueList.get(i) < min) {
                min = mapValueList.get(i);
            }
        }
        int d = max - min;
        // 2. 创建统计数组，并统计对应元素的个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < mapValueList.size(); i++) {
            countArray[mapValueList.get(i) - min]++;
        }
        Map<Integer,Integer> sortMap = new TreeMap<>();
        for (int i = 0; i < mapValueList.size(); i++) {
//            countArray[mapValueList.get(i) - min -1]

        }
    }

}
