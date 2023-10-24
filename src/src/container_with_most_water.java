public class container_with_most_water {

    public static void main(String[] args) {
//        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 25, 7};
//        int[] nums = {3,4,-1,1};
//        int[] nums = {1};
        System.out.println(new Solution().maxArea(nums));
    }

    static class Solution {
        public int maxArea(int[] height) {
            int max = -1;
//            for (int i = 0; i < height.length; ++i) {
//                for (int j = i + 1; j < height.length; ++j) {
//                    int sum = (j - i) * Math.min(height[j], height[i]);
//                    if (sum > max)
//                        max = sum;
//
//                }
//            }
//            int []sum = new int[height.length];
//            sum[0] = height[0];
            int target = -1;
            int max_height = height[0];
            int max_height_idx = 0;
            for (int i = 1; i < height.length; ++i) {
//                sum[i] = i * height[i];

                int n = Math.min(height[i], height[max_height_idx]) * (i - max_height_idx);
                if (n >= max) {
                    max = n;
                    target = i;
                }
                if (max_height > height[i]) {
                    max_height_idx = i;
                    max_height = height[i];
                }
            }
            max = -1;
            for (int i = 0; i < target; ++i) {
                int ss = (target - i) * Math.min(height[target], height[i]);
                if (ss > max)
                    max = ss;
            }
            return max;
        }
    }
}
