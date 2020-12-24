package week1.day1114;

import java.util.*;
import java.util.stream.Collectors;

class Test {
    public static void main(String[] args) {
        Set<Set> set = new HashSet<>();
        Set<Integer> list1 = new HashSet<>();
        list1.add(-1);
        list1.add(2);
        Set<Integer> list2 = new HashSet<>();
        list2.add(2);
        list2.add(-1);
        set.add(list1);
        set.add(list2);
        System.out.println(set);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            // 去重
            if (i == 0 || nums[i] != nums[i + 1]) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j == i + 1 || nums[j] != nums[j + 1]) {
                        for (int k = j + 1; k < nums.length - 1; k++) {
                            if (k == j + 1 || nums[k] != nums[k + 1]) {
                                if (nums[i] + nums[j] + nums[k] == 0) {
                                    List<Integer> list = new ArrayList<>();
                                    list.add(nums[i]);
                                    list.add(nums[j]);
                                    list.add(nums[k]);
                                    res.add(list);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int[] g = {};
        if (nums.length == 3) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            List<Integer> list = Arrays.stream(sum == 0 ? nums : g).boxed().collect(Collectors.toList());
            if (list.size() != 0) {
                return new ArrayList<List<Integer>>(Collections.singleton(list));
            }
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // -1, 0, 1, 2, -1, -4
//        Arrays .sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j != i && j < nums.length - 1; j++) {
                for (int k = 0; k != i && k != j && k < nums.length - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }
//        return res;
        return removeDuplicate(res);

    }

    private List<List<Integer>> removeDuplicate(List<List<Integer>> res) {
        List<List<Integer>> resList = new ArrayList<>();
        Set<Set> sets = new HashSet<>(res.size());
        for (List<Integer> list : res) {
            Set<Integer> set = new HashSet<>();
            for (Integer integer : list) {
                set.add(integer);
            }
            boolean success = sets.add(set);
            if (success) {
                resList.add(list);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0,0,0};
        int[] nums = new int[]{0, 1, 1};
        System.out.println(new Solution().threeSum1(nums));
    }
}
