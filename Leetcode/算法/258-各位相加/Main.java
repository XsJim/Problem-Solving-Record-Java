public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }
}

class Solution {
    // 循环计算
    public int addDigits(int num) {
        while (num / 10 != 0) {
            int sum = 0;
            while (num != 0) {
                sum += (num % 10);
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}