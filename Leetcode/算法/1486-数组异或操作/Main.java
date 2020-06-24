public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().xorOperation(5, 0));
        System.out.println(new Solution().xorOperation(4, 3));
        System.out.println(new Solution().xorOperation(1, 7));
        System.out.println(new Solution().xorOperation(10, 5));
    }
}

class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        while (n-- != 0) {
            ans ^= start;
            start += 2;
        }
        return ans;
    }
}