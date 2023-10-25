import java.util.ArrayList;
import java.util.Arrays;

public class daily_temperatures {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{99,99,99,99,99,99,99,99,99, 100})));
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ret = new int[temperatures.length];
            for (int i = 0; i < temperatures.length - 1; i++) {
                if(i > 0 && temperatures[i] >= temperatures[i-1])
                {
                    for (int j = ret[i-1] + i -1; j < temperatures.length; j++) {
                        if (temperatures[j] > temperatures[i]) {
                            ret[i] = j - i;
                            break;
                        }
                    }
                }else {
                    for (int j = i + 1; j < temperatures.length; j++) {
                        if (temperatures[j] > temperatures[i]) {
                            ret[i] = j - i;
                            break;
                        }
                    }
                }
            }

            return ret;
        }
    }
//            ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(71);
//            for (int i = 0; i < 100 - 30 + 1; i++) {
//                bucket.add(new ArrayList<>(temperatures.length / 71));
//            }
//            for (int i = 0; i < temperatures.length; i++) {
//                int temp = temperatures[i];
//                bucket.get(temp - 30).add(i);
//            }
//
//            for (int i = 0; i < temperatures.length; i++) {
//                int temp = temperatures[i];
//                int next = temp + 1;
//                for (; next <= 100 && bucket.get(next-30).isEmpty(); next++);
//                if(next > 100)
//                    continue;
//                ArrayList<Integer> cc = bucket.get(next-30);
//                for (int j = 0; j < cc.size(); j++) {
//                    if(cc.get(j) > i)
//                    {
//                        ret[i] = cc.get(j)-i;
//                        break;
//                    }
//                }
//                bucket.get(temp-30).remove((Integer) i);
//
//            }


}
