import java.util.Arrays;

public class coin_change {
    public static void main(String[] args) {
//        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution().coinChange(new int[]{1, 2}, 2));
//        System.out.println(new Solution().coinChange(new int[]{2,}, 3));
//        System.out.println(new Solution().coinChange(new int[]{1,}, 0));
//        System.out.println(new Solution().coinChange(new int[]{2147483647,}, 2));
    }

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if(amount == 0)
                return 0;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                min = Math.min(min, coin);
                if(amount >= coin)
                    dp[coin] = 1;
            }
            if(min > amount)
                return -1;
            for (int i = min + 1; i <= amount; i++) {

                min = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j] && dp[i - coins[j]] != -1) {
                        min = Math.min(dp[i - coins[j]] + 1, min);
                    }
                }
                if (min == Integer.MAX_VALUE)
                    dp[i] = -1;
                else
                    dp[i] = min;
            }


//            return dp[amount] == 0? -1 : dp[amount];
            return dp[amount];
        }
    }

}
