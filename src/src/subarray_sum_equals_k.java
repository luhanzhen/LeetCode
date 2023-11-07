public class subarray_sum_equals_k {
    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1}, 1));
        System.out.println(new Solution().subarraySum(new int[]{1, 2, 3, 4}, 3));
        System.out.println(new Solution().subarraySum(new int[]{1, 1, 1}, 2));
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {


            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int cnt = dp[0] == k ? 1 : 0;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
                if (dp[i] == k)
                    cnt++;
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (dp[j] - dp[i] == k)
                        cnt++;
                }
            }
            return cnt;
        }
    }
}
