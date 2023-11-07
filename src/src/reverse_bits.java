public class reverse_bits {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }

    static public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {

            int ret = 0;
            for (int i = 0; i < 32; i++) {
                int tail = n >> i & 0x1;
                if (tail == 1) {
                    ret |= 1 << (32 - i - 1);
                }
            }
            return ret;
        }
    }

}
