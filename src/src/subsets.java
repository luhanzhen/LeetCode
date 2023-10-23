import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> list = new Solution().subsets(nums);
        System.out.print("[");
        for (var e : list) {
            System.out.print(e + ", ");
        }
        System.out.print("]\n");
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int n = (int) Math.pow(2,nums.length);
            List<List<Integer>> ret = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int base = i;
                int j = 0;
                List<Integer> e = new ArrayList<>();
                while ( base != 0) {
                    if(base % 2 == 1)
                        e.add(nums[j]);
                    base = base >> 1;

                    j++;
                };
                ret.add(e);
            }
            return ret;
        }
    }
}
