public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(10));
    }
}

// 如果数字小于 0 ，则不可能构成回文数
// 大于等于 0 时，首先进行反转操作，将原数从个位开始倒序排列，得到一个新的数字
// 然后对比这两个数字是否相同便可知数字是否是回文数
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int xx = 0;
        int xxx = x;
        while (x != 0) {
            xx *= 10;
            xx += (x % 10);
            x /= 10;
        }
        return xxx == xx;
    }
}