public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(16));
        System.out.println(new Solution().isPowerOfFour(5));
        System.out.println(new Solution().isPowerOfFour(1));
    }
}

class Solution {
    // 从二进制的角度看，一个数如果为 4 的幂，那么二进制表示中只有一位是 1 ，且这一位 1 在奇数位
    // 判断数字是否只有一位是 1 ，可以通过它和它减一的与是否为 0 来判断
    // 判断这一位是否为奇数位，可以通过它和 0xaaaaaaaa 的与是否为 0 来判断
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (0xaaaaaaaa & num) == 0; 
    }
}