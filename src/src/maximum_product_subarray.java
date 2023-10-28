public class maximum_product_subarray {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{1, 0, -1, 2, 3, -5, -2}));
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Solution().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new Solution().maxProduct(new int[]{0,2}));
        System.out.println(new Solution().maxProduct(new int[]{-2,3,-4}));
    }

    static class Solution {
        public int maxProduct(int[] nums) {

            int[] select_max_non_zero = new int[nums.length + 1];
            int[] select_min_non_zero = new int[nums.length + 1];

            select_max_non_zero[1] = nums[0];

            select_min_non_zero[1] = nums[0];
            int max =  nums[0];
            for (int i = 2; i <= nums.length; i++) {

                select_min_non_zero[i] = Math.min(Math.min(nums[i-1],select_min_non_zero[i-1] * nums[i-1]),select_max_non_zero[i-1] * nums[i-1]);
                select_max_non_zero[i] = Math.max(Math.max(nums[i-1],select_min_non_zero[i-1] * nums[i-1]),select_max_non_zero[i-1] * nums[i-1]);
                max = Math.max(max,select_max_non_zero[i]);
            }

            return max;
        }
//        public int maxProduct(int[] nums) {
//            if(nums.length == 1)
//                return nums[0];
//            int[][] dp = new int[nums.length + 1][];
//            for (int i = 0; i <= nums.length; i++) {
//                dp[i] = new int[nums.length + 1];
//            }
//            dp[1][1] = nums[0];
//            int max = dp[1][1];
//            for (int i = 2; i <= nums.length; i++)
//            {
//                dp[1][i] = dp[1][i-1] * nums[i - 1];
//                max = Math.max(max, dp[1][i]);
//            }
//
//
//            for (int i = 2; i <= nums.length; i++) {
//                dp[i][i] = nums[i - 1];
//                max = Math.max(max, dp[i][i]);
//                for (int j = i + 1; j <= nums.length; j++) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] * nums[j - 1]);
//                    max = Math.max(max, dp[i][j]);
//                }
//            }
//
//            return max;
//        }

//        public int maxProduct(int[] nums) {
//            int[] dp = new int[nums.length];
//            dp[0] = nums[0];
//            int max = nums[0];
//            for (int i = 1; i < nums.length; i++) {
//                dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
//                max = Math.max(max, dp[i]);
//            }
//
//            return max;
//        }
    }
}
