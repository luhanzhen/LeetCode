import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class word_break {
    public static void main(String[] args) {

//        List<String> dic = Arrays.asList(new String[]{"leet", "code"});
        List<String> dic = Arrays.asList(new String[]{"apple", "pen"});
//        System.out.println(new Solution().wordBreak("leetcode", dic));
        System.out.println(new Solution().wordBreak("applepenapple", dic));
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean []dp = new boolean[s.length()+1];
            Arrays.fill(dp,false);
            HashSet<String> map = new HashSet<>(wordDict);
            for (int i = 1; i <= s.length(); i++) {
                String sub = s.substring(0,i);
                if(map.contains(sub))
                    dp[i] = true;
                else
                {
                    boolean flag= false;
                    for (int j = 1; j < i; j++) {

                        flag = dp[j] && map.contains(sub.substring(j,i));
                        if(flag)
                            break;
                    }
                    dp[i] = flag;
                }

            }

            return dp[s.length()];
        }
    }
}
