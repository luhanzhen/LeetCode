public class longest_increasing_subsequence {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new Solution().lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(new Solution().lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(new Solution().lengthOfLIS(new int[]{0}));
    }
    static class Solution {
        public int lengthOfLIS(int[] nums) {


            int []dp = new int[nums.length];
            int max = 1;
            dp[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                int m = 1;
                for (int j = 0; j < i; j++) {
                    if(nums[j] < nums[i] && m <= dp[j])
                    {
                        m = dp[j] + 1;
                    }
                }
                dp[i] = m;
                max = Math.max(dp[i],max);
            }
            return max;
        }
    }
}
