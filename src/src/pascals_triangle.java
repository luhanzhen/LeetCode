import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pascals_triangle {

    public static void main(String[] args) {


        List<List<Integer>> list = new Solution().generate(5);
        System.out.print("[");
        for (var e : list) {
            System.out.print(e + ", ");
        }
        System.out.print("]\n");
    }

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>());
            ret.get(0).add(1);
            for (int i = 1; i < numRows; i++) {

                var last = ret.get(i - 1);
                var current = new ArrayList<Integer>();
                current.add(1);
                for (int j = 1; j < last.size(); j++) {
                    current.add(last.get(j) + last.get(j-1));
                }
                current.add(1);
                ret.add(current);
            }

            return ret;
        }
    }
}
