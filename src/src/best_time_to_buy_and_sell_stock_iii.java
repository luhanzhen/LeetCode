
// unfinished
public class best_time_to_buy_and_sell_stock_iii {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
        System.out.println(new Solution().maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new Solution().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new Solution().maxProfit(new int[]{1}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int[] current_min = new int[prices.length];
            int[] current_max = new int[prices.length];
            int[] current_min_idx = new int[prices.length];
            current_min_idx[0] = 0;
            current_min[0] = prices[0];
            int one_time_max = 0;
            current_max[prices.length - 1] = prices[prices.length - 1];
            for (int i = 1; i < prices.length; i++) {
//                current_min[i] = Math.min(current_min[i - 1], prices[i]);
                if (current_min[i - 1] < prices[i]) {
                    current_min[i] = current_min[i - 1];
                    current_min_idx[i] = current_min_idx[i - 1];
                } else {
                    current_min[i] = prices[i];
                    current_min_idx[i] = i;
                }
                one_time_max = Math.max(prices[i] - current_min[i], one_time_max);
            }
            for (int i = prices.length - 2; i >= 0; i--) {
                current_max[i] = Math.max(current_max[i + 1], prices[i]);
            }
            int two_time_max = 0;
            for (int i = 1; i < prices.length - 1; i++) {
                if (current_min[i] < prices[i]) {
                    int min = prices[i + 1];
                    int first = prices[i] - current_min[i];
                    if (current_min[i + 1] > current_min[prices.length - 1] && current_max[prices.length - 1] > current_min[prices.length - 1]) {
                        two_time_max = first + current_max[current_min_idx[prices.length - 1]] - current_min[prices.length - 1];
                        continue;
                    }
                    for (int j = i + 2; j < prices.length; j++) {
                        if (prices[j] > min) {
                            two_time_max = Math.max(first + prices[j] - min, two_time_max);
                        } else {
                            min = prices[j];
                        }
                    }
                }
            }
            return Math.max(one_time_max, two_time_max);
        }
    }
}
