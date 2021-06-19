public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(4));
        System.out.println(new Solution().mySqrt(8));
        System.out.println(new Solution().mySqrt(2147395600));
    }
}

// 用二分查找从可能的值中找出答案
// 因为 left 比可能值 mid 大 1 ，所以最终得到的 left 要比答案大 1
// 如果 left 和 right 相等，说明当前 x 的平方根就是这个值，但是由于最终返回的答案是 left - 1
// 所以要求 left 的值再加 1 ，也就是说，在 left 和 right 相等时，要再进行一次查找

class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid <= x) left = mid + 1;
            else right = mid - 1;
        }
        

        return (int)left - 1;
    }
}