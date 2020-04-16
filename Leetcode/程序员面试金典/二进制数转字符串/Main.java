public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().printBin(0.625));
        System.out.println(new Solution().printBin(0.1));
    }
}

class Solution {
    public String printBin(double num) {
        if (num >= 1 || num <= 0) return "ERROR";
        int i = 0; double x = 0.5;
        String ans = "0.";
        while (i < 30 && num > 0) {
            if (num - x < 0) ans += "0";
            else {
                num -= x;
                ans += "1";
            }
            x /= 2; i++;
        }
        if (num != 0) return "ERROR";
        return ans;
    }
}