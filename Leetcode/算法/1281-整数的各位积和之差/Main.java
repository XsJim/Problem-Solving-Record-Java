public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().subtractProductAndSum(234));
        System.out.println(new Solution().subtractProductAndSum(4421));
    }
}

class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int pro = 1;
        while (n != 0) {
            int x = n % 10;
            sum += x;
            pro *= x;
            n /= 10;
        }
        return pro - sum;
    }
}