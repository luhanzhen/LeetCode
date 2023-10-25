public class perfect_squares {
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }

    static class Solution {
        public int numSquares(int n) {


            int[] nums = new int[100 + 1];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = i * i;
            }
//            int min = Integer.MAX_VALUE;
            int []dp = new int[n+1];

            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
//                int sqrt = (int)Math.sqrt(i);
//                dp[i] = dp[i-sqrt * sqrt] + 1;
                int min = Integer.MAX_VALUE;
                for (int j = 1; nums[j] <= i; j++) {
                    min = Math.min(dp[i-j * j] + 1,min);
                }
                dp[i] = min;
            }

            return dp[n];
        }
    }

}
