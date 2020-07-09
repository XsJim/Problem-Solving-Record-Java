public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(1));
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(4));
    }
}

class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n > 1) {
            int temp = a + b;
            a = b;
            b = temp;
            n--;
        }
        return b;
    }
}