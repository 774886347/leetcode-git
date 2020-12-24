package week7.day1222;

import java.util.HashSet;
import java.util.Set;

class SingleNumber136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int before = 0;
        int after = 0;
        for (int i = 0; i < nums.length; i++) {
            before = set.size();
            set.add(nums[i]);
            after = set.size();
            if (after == before) {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(new SingleNumber136().singleNumber(nums));
    }
}