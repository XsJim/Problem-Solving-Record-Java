public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(16));
        System.out.println(new Solution().isPerfectSquare(14));
    }
}

// 二分枚举 1 ~ 给定值内的数，需要注意的是当给定值很大时，做平方操作可能会超出 int 范围
class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        while (l <= r) {
            long m = (l + r) / 2;
            long mm = m * m;
            if (mm > num) r = m - 1;
            else if (mm < num) l = m + 1;
            else return true;
        }
        return false;
    }
}