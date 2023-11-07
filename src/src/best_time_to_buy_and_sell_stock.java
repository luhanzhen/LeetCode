public class best_time_to_buy_and_sell_stock {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }
    static class Solution {
        public int maxProfit(int[] prices) {
            int []current_min = new int[prices.length];
            int min = prices[0];
            for (int i = 0; i < prices.length-1; i++) {
                min = Math.min(min,prices[i]);
                current_min[i+1] = min;
            }
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max = Math.max(max,prices[i] - current_min[i]);
            }
            return max;
        }
    }
}
