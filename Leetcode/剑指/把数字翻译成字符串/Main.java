public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
        System.out.println(new Solution().translateNum(1111));
        System.out.println(new Solution().translateNum(943521879));
        System.out.println(new Solution().translateNum(624));
        System.out.println(new Solution().translateNum(1250156147));
    }
}


class Solution {
    public int translateNum(int num) {
        return talgo(num);
    }

    private static int talgo(int num) {
        if (num < 10) return 1;
        int n = num % 100;
        if (n < 10 || n > 25) {
            return talgo(num / 10);
        }
        return talgo(num / 10) + talgo(num / 100);
    }
}