public class remove_element {
    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums = new int[]{0,4,4,0,4,4,4,0,2};
        int n = new Solution().removeElement(nums, 4);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int last = nums.length - 1;
            while (last >= 0 && nums[last] == val) {
                last--;
            }
            if (last < 0)
                return 0;
            int first = 0;
            while (first <= last) {
                if (nums[first] == val) {
                    nums[first] = nums[last];
                    nums[last] = val;
                    while (last >= 0 && nums[last] == val) {
                        last--;
                    }
                }
                first++;

            }
            return last+1;

        }
    }
}
