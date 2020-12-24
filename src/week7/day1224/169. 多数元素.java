package week7.day1224;


import java.util.HashMap;
import java.util.Map;

class MajorityElement {

    public int majorityElement(int[] nums) {
        int targetSize = (int) Math.round(nums.length / 2.0);
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer value = map.get(num);
                value += 1;
                map.put(num, value);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= targetSize) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
}