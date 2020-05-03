public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(3));
        System.out.println(new Solution().trailingZeroes(5));
    }
}

class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}