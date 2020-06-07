public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(0b00000000000000000000000000001011));
        System.out.println(new Solution().hammingWeight(0b00000000000000000000000010000000));
        System.out.println(new Solution().hammingWeight(0b11111111111111111111111111111101));
    }
}

class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}