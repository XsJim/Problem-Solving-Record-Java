public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().totalMoney(4));
        System.out.println(new Solution().totalMoney(10));
        System.out.println(new Solution().totalMoney(20));
    }
}

// 找规律
class Solution {
    public int totalMoney(int n) {
        int ind = (n - 1) / 7;

        int x = ind * 7 + 1;

        int y = 1 + ind * 29 + ind * (ind - 1) * 7 / 2;

        int z = ind + 2;

        int nn = n - x;

        int sum = y + nn * z + nn * (nn - 1) / 2;
        return sum;
    }
}