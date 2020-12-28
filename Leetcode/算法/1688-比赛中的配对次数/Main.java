public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 200; i++) System.out.println(new Solution().numberOfMatches(i));
    }
}

// 模拟过程打表，发现规律
class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}