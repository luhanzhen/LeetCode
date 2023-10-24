import java.util.HashMap;

public class majority_element {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new Solution().majorityElement(nums));
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (var e : nums) {
                if (map.containsKey(e)) {
                    int v = map.get(e);
                    map.put(e, v + 1);
                } else {
                    map.put(e, 1);
                }
            }
            int max = 0;
            int v = 0;
            for (var e : map.entrySet()) {
                if (max < e.getValue()) {
                    max = e.getValue();
                    v = e.getKey();
                }
            }
            return v;

        }
    }
}


// double sum = 0;
// for(var e : nums)
// {
//     sum +=e;
// }
// sum /= nums.length;
// for(var e : nums)
// {
//      if((double)e >= sum)
//         return e;
// }
// return 0;