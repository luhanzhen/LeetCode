import java.util.*;

public class group_anagrams {

    public static void main(String[] args) {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = new Solution().groupAnagrams(strs);
        System.out.print("[");
        for (var e : list) {
            System.out.print(e + ", ");
        }
        System.out.print("]\n");
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            List<List<String>> ret = new ArrayList<>();

            HashMap<String,Integer> map = new HashMap<>();

            for(String str : strs)
            {
//                long sum = 1;
                char[] newchar = str.toCharArray();
                Arrays.sort(newchar);
                String ss = new String(newchar);
//                for (int i = 0; i < str.length(); i++) {
//                    sum *= (ss.charAt(i));
////                    sum %= Long.MAX_VALUE;
//                }

                if(map.containsKey(ss))
                {
                    int idx  = map.get(ss);
                    ret.get(idx).add(str);
                }else
                {
                    ret.add(new ArrayList<>());
                    ret.get(ret.size()-1).add(str);
                    map.put(ss,ret.size()-1);
                }


            }

            return ret;
        }
    }
}
