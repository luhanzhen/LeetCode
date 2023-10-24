import java.util.Arrays;

public class first_missing_positive {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
//        int[] nums = {3,4,-1,1};
//        int[] nums = {1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            int []bucket = new int[nums.length+1];
            Arrays.fill(bucket,0);
            int min = 1;
            for (int num : nums) {
                if (num < 0 || num > nums.length)
                    continue;
                bucket[num] = 1;
                if (min == num) {
                    do {
                        min++;
                    } while (min < bucket.length && bucket[min] != 0);

                }
            }
            return min;
        }
    }

}
