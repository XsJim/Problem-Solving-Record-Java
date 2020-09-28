public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("AB"));
    }
}

class Solution {
    // 模拟
    public int calculate(String s) {
        int x = 1, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }

        return x + y;
    }
}