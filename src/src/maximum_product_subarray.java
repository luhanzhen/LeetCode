public class maximum_product_subarray {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
}
