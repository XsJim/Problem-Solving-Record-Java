public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(0b00000010100101000001111010011100));
        System.out.println(new Solution().reverseBits(0b11111111111111111111111111111101));
    }
}

class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
        }
        return ans;
    }
}