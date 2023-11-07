public class h_index_ii {
    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{11,15}));
        System.out.println(new Solution().hIndex(new int[]{1, 2}));
        System.out.println(new Solution().hIndex(new int[]{0, 1, 1, 1}));
        System.out.println(new Solution().hIndex(new int[]{0, 0}));
        System.out.println(new Solution().hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(new Solution().hIndex(new int[]{1, 2, 100}));
        System.out.println(new Solution().hIndex(new int[]{2, 100}));
    }

    static class Solution {
        public int hIndex(int[] citations) {

            int n = citations.length;
            if (n == 0)
                return 0;
            if (n == 1)
                return citations[0] == 0 ? 0 : 1;
            if(citations[0] >= n)
                return n;

            int left = 0;
            int right = citations.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (citations[mid] < n - mid ) {
                    left = mid + 1;
                } else if(citations[mid] == n - mid )
                    return citations[mid];
                else {
                    if (citations[mid - 1] < n - mid + 1) {
                        return n - mid;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return 0;
        }
    }
}
