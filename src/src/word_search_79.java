import java.util.Arrays;


//https://leetcode.cn/problems/word-search/


public class word_search_79 {

    public static void main(String[] args) {

        Solution S = new Solution();
        char[][] board = {new char[]{'A', 'B', 'C', 'E'}, new char[]{'S', 'F', 'E', 'S'}, new char[]{'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(S.exist(board, word));
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            _board = board;
            _word = word;
            m = board.length;
            n = board[0].length;
            visited = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == word.charAt(0)) {
                        for (int k = 0; k < m; k++) {
                            Arrays.fill(visited[k], 0);
                        }
                        if (find(i, j, 0))
                            return true;
                    }
                }
            }
            return false;
        }

        char[][] _board;
        int[][] visited;
        int m;
        int n;
        String _word;

        private boolean find(int i, int j, int k) {
            if (k >= _word.length())
                return false;
            //  if (k > _word.length())
            // return false;
            if (i < 0 || j < 0 || j >= n || i >= m || visited[i][j] == 1)
                return false;


            if (_board[i][j] == _word.charAt(k)) {
                visited[i][j] = 1;
                if (k == _word.length() - 1)
                    return true;
                else {
                    boolean rr = find(i - 1, j, k + 1) || find(i, j - 1, k + 1) || find(i + 1, j, k + 1) || find(i, j + 1, k + 1);
                    if(!rr)
                    {
                        visited[i][j] = 0;
                    }
                    return rr;
                }
            } else
                return false;
        }
    }
}
