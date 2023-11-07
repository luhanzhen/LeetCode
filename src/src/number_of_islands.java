
// unfinished
public class number_of_islands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid1 = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(new Solution().numIslands(grid));
        System.out.println(new Solution().numIslands(grid1));
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int number = 0;
//            for (int i = m - 1; i >= 0; i--) {
//                for (int j = n - 1; j >= 0; j--) {
//                    if (grid[i][j] == '1') {
//                        if (i > 0 && grid[i - 1][j] == '1' || j > 0 && grid[i][j - 1] == '1') {
//                            grid[i][j] = '2';
//                        }
//                    }
//                    if (grid[i][j] == '1') {
//                        if ((i == 0 && j == 0) || (j == 0 && grid[i - 1][j] == '0') || (i == 0 && grid[i][j - 1] == '0') || (i != 0 && j != 0 && grid[i - 1][j] == '0' && grid[i][j - 1] == '0')) {
//                            number++;
//                        }
//                    }
//                }
//            }
            return number;

        }
    }
}
