package exec202506;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * @author CSM
 * @date 2025-06-28 23:02:07
 */
public class P18_FourSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P18_FourSum().new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);

        System.out.println(lists);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n - 3; i++) {
                if (i > 0 && nums[i] == nums[i-1]) continue;
                long min1 = (long) nums[i]+ nums[i+1]+nums[i+2]+ nums[i+3];
                if (min1 > target) break;
                long max1 = (long) nums[i] + nums[n-3] + nums[n - 2] + nums[n - 1];
                if (max1 < target) continue;

                for (int j = i + 1; j < n - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                    long min2 = (long) nums[i] + nums[j] + nums[j+1] + nums[j+2];
                    if (min2 > target) break;

                    long max2 = (long) nums[i] + nums[j] + nums[n-2] + nums[n -1];
                    if (max2 < target) continue;
                    int l = j + 1, r = n - 1;
                    while (l < r) {
                        long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[l] , nums[r]));
                            while (l < r && nums[l] == nums[l+1]) l++;
                            while (l < r && nums[r] == nums[r-1]) r--;
                            l++; r--;
                        } else if (sum < target) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
            return res;
        }
    }
}
