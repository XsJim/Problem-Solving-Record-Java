public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().binaryGap(22));
        System.out.println(new Solution().binaryGap(5));
        System.out.println(new Solution().binaryGap(6));
        System.out.println(new Solution().binaryGap(8));
    }
}

class Solution {
    public int binaryGap(int N) {
        int i = 0, j = 31;
        int ans = 0;
        while (N != 0) {
            if ((N & 1) == 1) {
                ans = Math.max(i - j, ans);
                j = i;
            }
            i++; N >>= 1;
        }
        return ans;
    }
}