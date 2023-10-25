public class min_modification_strings {
    public static void main(String[] args) {


//        System.out.println(modify("9873007613", "87300676513", 5));
//        System.out.println(modify("zhenluhan", "lizhanshan", 5));
        System.out.println(modify("play", "game", 5));
    }

    static int modify(String A, String B, int K) {

        int[][] matrix = new int[A.length()+1][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[B.length()+1];
            matrix[i][0] = i;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i-1) == B.charAt(j-1))
                {
                    matrix[i][j] = matrix[i - 1][j - 1];
                }else
                {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1), matrix[i - 1][j - 1] + 2);
                }
//                int n = 0;
//                if (A.charAt(i) == B.charAt(j))
//                    n = 0;
//                else
//                    n = 1;
//                matrix[i][j] = Math.min(Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1), matrix[i - 1][j - 1] + 2 * n);
            }
        }
        return matrix[A.length() ][B.length()];

    }
}
