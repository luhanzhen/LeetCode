import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class merge_intervals {
    public static void main(String[] args) {


//        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int[][] nums = {{2, 3}, {4, 6}, {5, 7}, {3, 4}};
//        int[][] nums = {{2,3},{4,5},{6,7},{8,9},{1,10}};
//        int[][] nums = {{1,4},{2,3}};

        System.out.println(Arrays.deepToString(new Solution().merge(nums)));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            for (int i = 0; i < intervals.length; i++) {

                for (int j = 0; j < intervals.length; j++) {
                    if (intervals[i][0] < intervals[j][0] || intervals[i][0] == intervals[j][0] && intervals[i][1] < intervals[j][1]) {
                        int[] t = intervals[i];
                        intervals[i] = intervals[j];
                        intervals[j] = t;
                    }
                }
            }
            ArrayList<int[]> ret = new ArrayList<>();
            int max = intervals[0][1];
            int min = intervals[0][0];
            for (int i = 1; i < intervals.length; i++) {

                if(max < intervals[i][0])
                {
                    ret.add(new int[]{min,max});
                    if(i+1<intervals.length) {
                        max = intervals[i + 1][1];
                        min = intervals[i + 1][0];
                        i++;
                    }
                }else if(min <= intervals[i][0])
                {
                    max = intervals[i][0];
                }
                else if(max >= intervals[i][1])
                {
                    max = intervals[i][1];
                }
            }
            int [][] rett = new int[ret.size()][];
            for (int i = 0; i < ret.size(); i++) {
                rett[i] = ret.get(i);
            }
            return  rett;
        }
    }
}
//    static class Solution {
//        public int[][] merge(int[][] intervals) {
////            int []bucket = new int[10000];
////            Arrays.fill(bucket,-1);
////            HashSet<Integer> valid = new HashSet<>(intervals.length);
//            HashMap<Integer,Integer> map = new HashMap<>(intervals.length);
//
//            for (int i = 0; i < intervals.length; i++) {
//                int [] tuple = intervals[i];
//                boolean flag = false;
//                var set = map.keySet().stream().toList();
//                for(var l : set)
//                {
////                    int l = entry.getKey();
////                    int r = entry.getValue();
//                    if(!map.containsKey(l))
//                        continue;
//                    int r = map.get(l);
//                    if(r == -1)
//                        continue;
//                    if(l == tuple[1])
//                    {
//                        map.remove(l);
//
//                        map.put(tuple[0],r);
//                        flag = true;
////                        break;
//                    }else if(r == tuple[0])
//                    {
//                        map.remove(l);
//                        map.put(l,tuple[1]);
//                        flag = true;
////                        break;
//                    }else if(l >= tuple[0] && r <= tuple[1]) //新tuple包含了entry
//                    {
////                        map.remove(l);
//                        map.replace(tuple[0],tuple[1]);
//                        map.remove(l);
//
////                        flag = true;
//                    }
//                    else if(l <= tuple[0] && r >= tuple[1]) //新tuple包含了entry
//                    {
////                        map.remove(l);
////                        map.replace(tuple[0],tuple[1]);
////                        map.replace(l,-1);
//
//                        flag = true;
//                    }
//                    else if(l >= tuple[0] && l <= tuple[1] && tuple[1] <= r) //新tuple[1]在entry中
//                    {
//
//                        map.remove(l);
//                        map.put(tuple[0],r);
//                        flag = true;
////                        break;
//                    }else if(l <= tuple[0] && tuple[0] <= r && r <= tuple[1]) //新tuple[0]在entry中
//                    {
//
//                        map.replace(l,tuple[1]);
//                        flag = true;
////                        break;
//                    }else{ //无关
////                        flag = true;
//
//                    }
//                }
//                if(!flag)
//                {
//                    map.put(tuple[0],tuple[1]);
//                }
//                map.values().removeIf(e->e==-1);
//            }
////            map.entrySet().stream().filter(e->e.getValue()!=-1).collect(Collectors.toMap(k,v));
//
//            int [][] ret = new int[map.size()][];
//            int i = 0;
//            for(var entry : map.entrySet())
//            {
//                ret[i++] = new int[]{entry.getKey(), entry.getValue()};
//            }
//            return ret;
//        }
//    }

//    boolean f = false;
//                int j = 0;
//                for (j = tuple[0]+1; j < tuple[1]; j++) {
//                    if(bucket[j] >= 0)
//                    {
//                        bucket[tuple[0]] = Math.max(tuple[1],bucket[j]);
//
//                        bucket[j] = -1;
//                        valid.remove(j);
//                        valid.add(tuple[0]);
//                        f = true;
//                        break;
//                    }
//                }
//                if (f)
//                    continue;
//                for (j = tuple[0]; j >= 0 ; j--) {
//                    if(bucket[j] >= 0)
//                    {
//                        if(tuple[0] > bucket[j])
//                            break;
//                        bucket[j] = Math.max(tuple[1],bucket[j]);
////                        f = true;
//                        break;
//                    }
//                }
//                if (j < 0)
//                    continue;
//                for (j = tuple[0]; j <= tuple[1]; j++)
//                {
//                    if(bucket[j] >= 0)
//                    {
//                        if(tuple[1] > bucket[j])
//                            break;
//                        bucket[tuple[0]] =  bucket[j];
//                        bucket[j] = -1;
//                        valid.remove(j);
//                        valid.add(tuple[0]);
////                        f = true;
//                        break;
//                    }
//                }
//                if (j > tuple[1])
//                    continue;
//                bucket[tuple[0]] = tuple[1];
//                valid.add(tuple[0]);