public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getHappyString(1, 3));
        System.out.println(new Solution().getHappyString(1, 4));
        System.out.println(new Solution().getHappyString(3, 9));
        System.out.println(new Solution().getHappyString(2, 7));
        System.out.println(new Solution().getHappyString(10, 100));
    }
}

class Solution {
    public String getHappyString(int n, int k) {
        char[] ans = new char[n];
        int[] num = new int[1];
        for (int j = 0; j < 3; j++) {
            ans[0] = (char)(j+'a');
            talgo(ans, num, k, 1);
            if (num[0] == k) return new String(ans);
        }
        return "";
    }

    private static void talgo(char[] ans, int[] num, int k, int i) {
        if (i == ans.length) {
            num[0]++;
            return;
        }

        for (int j = 0; j < 3; j++) {
            char x = (char)(j+'a');
            if (ans[i-1] != x) {
                ans[i] = x;
                talgo(ans, num, k, i+1);
                if (num[0] == k) return;
            }
        }
    }
}