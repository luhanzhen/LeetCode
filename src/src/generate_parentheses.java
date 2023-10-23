import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class generate_parentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    static class Solution {

        public List<String> generateParenthesis(int n) {
            ArrayList<HashSet<String>> set = new ArrayList<>(n);
            set.add(new HashSet<>());
            set.get(0).add("()");
            for (int i = 1; i < n; i++) {
                HashSet<String> s = new HashSet<>();
                for (String bracket : set.get(i - 1)) {
                    s.add("(" + bracket + ")");
                    for (int j = 0; j < bracket.length(); j++) {
                        s.add(bracket.substring(0,j) + "()" + bracket.substring(j));
                    }
                }
                set.add(s);
            }

            return set.get(n - 1).stream().toList();
        }
    }

}
