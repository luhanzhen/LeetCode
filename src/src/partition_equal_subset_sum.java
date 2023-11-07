import java.util.Arrays;
import java.util.HashSet;

// unfinished
public class partition_equal_subset_sum {

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Solution().canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(new Solution().canPartition(new int[]{3, 3, 3, 4, 5}));
    }

    static class Solution {
        public boolean canPartition(int[] nums) {

            Arrays.sort(nums);
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            for (int e : nums) {
                set.add(e);
                sum += e;
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (sum - nums[i] == nums[i])
                    break;
                if (sum < nums[i])
                    return false;
                if (!set.contains((sum - nums[i] - nums[i]) / 2))
                    return false;
                sum -= nums[i];
            }
            return true;
        }
    }

}
