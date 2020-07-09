public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToBase7(100));
        System.out.println(new Solution().convertToBase7(-7));
    }
}

class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num *= -1;
        }
        int b = 20;
        int[] ans = new int[b];
        while (num != 0) {
            ans[--b] = (num % 7);
            num /= 7;
        }

        StringBuilder sb = new StringBuilder();
        if (flag) sb.append('-');
        while (b < 20) {
            sb.append(ans[b++]);
        }

        return sb.toString();
    }
}