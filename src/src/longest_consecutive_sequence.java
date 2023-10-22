import java.util.HashMap;
import java.util.HashSet;

public class longest_consecutive_sequence {

    public static void main(String[] args) {

//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {1,2,0,1};
//        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int[] nums = {-2,-3,-3,7,-3,0,5,0,-8,-4,-1,2};
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new Solution().longestConsecutive(nums));
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> Low2Up = new HashMap<>();
            HashMap<Integer, Integer> Up2Low = new HashMap<>();
            HashSet<Integer> used = new HashSet<>();
            for (int num : nums) {
                if(used.contains(num))
                    continue;
                used.add(num);
                boolean ulAdd = Up2Low.containsKey(num+1);
                boolean ulSub = Up2Low.containsKey(num-1);
                boolean luAdd = Low2Up.containsKey(num+1);
                boolean luSub = Low2Up.containsKey(num-1);

                if (!ulAdd && !ulSub && !luAdd && !luSub  ) {
                    Low2Up.put(num, num);
                    Up2Low.put(num, num);
                }
                if(luAdd && ulSub)
                {
                    int u = Low2Up.get(num+1);
                    int l = Up2Low.get(num-1);
                    Low2Up.remove(num+1);
                    Low2Up.put(l,u);
                    Up2Low.remove(num-1);
                    Up2Low.put(u,l);

                }
                else if (luSub || ulSub) {
                    int u = num;
                    int l = luSub ? Low2Up.get(num-1): Up2Low.get(num-1);
                    Up2Low.remove(l);
                    Up2Low.put(u,l);
                    Low2Up.put(l,u);
                }
                else if(luAdd || ulAdd)
                {
                    int u = luAdd ? Low2Up.get(num+1):Up2Low.get(num+1);
                    int l = num;
                    Low2Up.remove(u);
                    Low2Up.put(l,u);
                    Up2Low.put(u,l);
                }
            }
            int max = 0;

            for(var k :Low2Up.entrySet())
            {
                int n = k.getValue()-k.getKey() + 1;
                max = Math.max(max,n);
            }

            return max;
        }
    }

}
