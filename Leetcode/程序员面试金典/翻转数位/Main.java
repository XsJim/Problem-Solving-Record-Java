public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1775));
        System.out.println(new Solution().reverseBits(7));
        System.out.println(new Solution().reverseBits(0));
        System.out.println(new Solution().reverseBits(0b10001));
    }
}

class Solution {
    public int reverseBits(int num) {
        int max = 0;
        int a = 0;
        int b = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                b++;
            } else {
                a += b;
                a++;
                if (a > max) max = a;
                a = b;
                b = 0;
            }
            num >>= 1;
        }
        a += b;
        a++;
        if (a > max) max = a;
        return max;
    }
}