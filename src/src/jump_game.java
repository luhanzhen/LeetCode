public class jump_game {

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 5, 0, 0}));
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{2, 0}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1)
                return true;
            int max = nums[0];
            int start = 0;
            while (max < nums.length - 1) {
                int tmp_max = -1;
                int tmp_start = start;
                for (int i = start; i <= max; i++) {
                    if (i + nums[i] > tmp_max) {
                        tmp_max = i + nums[i];
                        tmp_start = i;
                    }
                }
                if (max == tmp_max)
                    return false;
                max = tmp_max;
                start = tmp_start;

            }
            return true;

        }
    }

}
