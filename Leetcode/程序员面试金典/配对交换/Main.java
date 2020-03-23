public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().exchangeBits(2));
        System.out.println(new Solution().exchangeBits(3));
        System.out.println(new Solution().exchangeBits(0));
        System.out.println(new Solution().exchangeBits(0b01111111111111111111111111111111));
        System.out.println(new Solution().exchangeBits(0b10111111111111111111111111111111));
        System.out.println(0b10111111111111111111111111111111);
    }
}

class Solution {
    public int exchangeBits(int num) {
        return ((num & 0x55555555) << 1) | ((num & 0xAAAAAAAA) >> 1);
    }
}