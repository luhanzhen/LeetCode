public class maximum_subarray {
    public static void main(String[] args) {

//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {1,2,0,1};
//        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new Solution().maxSubArray(nums));
    }
    static class Solution {
        public int maxSubArray(int[] nums) {
            int []dp = new int[nums.length];
            dp[0] = nums[0];
            int max = dp[0];
            for(int i = 1;i < dp.length;++i)
            {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
