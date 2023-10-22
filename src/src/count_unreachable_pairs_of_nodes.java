import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/?envType=daily-question&envId=2023-10-21
public class count_unreachable_pairs_of_nodes {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>();
//        ArrayList<Integer> B = new ArrayList<>();
//        A = (ArrayList<Integer>) A.stream().filter(e->!B.contains(e)).collect(Collectors.toList());
        int n = 11;
        int[][] edges = {{5,0},{1,0},{10,7},{9,8},{7,2},{1,3},{0,2},{8,5},{4,6},{4,2}};
//        {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
        System.out.println(new Solution().countPairs(n, edges));
    }

    static class Solution {
        public long countPairs(int n, int[][] edges) {
            ArrayList<HashSet<Integer>> component = new ArrayList<>();
            int[] visit = new int[n];
            Arrays.fill(visit, -1);
            for (int[] edge : edges) {
                if (visit[edge[0]] != -1 || visit[edge[1]] != -1) {
                    if (visit[edge[0]] != -1 && visit[edge[1]] != -1 && visit[edge[0]] != visit[edge[1]]) {
                        component.get(visit[edge[0]]).addAll(component.get(visit[edge[1]]));
                        int t = visit[edge[1]];
                        for(var e : component.get(visit[edge[1]]))
                            visit[e] = visit[edge[0]];
                        component.set(t, null);
                    }
                    int idx = visit[edge[0]] == -1 ? visit[edge[1]] : visit[edge[0]];
                    var set = component.get(idx);
                    set.add(edge[0]);
                    set.add(edge[1]);
                    visit[edge[0]] = idx;
                    visit[edge[1]] = idx;
                } else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(edge[0]);
                    set.add(edge[1]);
                    component.add(set);
                    visit[edge[0]] = component.size() - 1;
                    visit[edge[1]] = component.size() - 1;
                }
            }
            int cnt = 0;
            int count = 0;
            int m = 0;
            for (int i = 0; i < component.size(); i++) {
                if (component.get(i) != null) {
                    cnt += component.get(i).size();
                    m++;
                    for (int j = i + 1; j < component.size(); j++) {
                        if (component.get(j) != null)
                            count += component.get(i).size() * component.get(j).size();
                    }
                }
            }
            if (m + n - cnt < 2)
                return 0;

            count += (n - cnt) * (n - cnt - 1) / 2 + (n - cnt) * cnt;

            return count;

        }
    }
}
