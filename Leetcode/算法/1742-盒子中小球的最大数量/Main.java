public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countBalls(1, 10));
        System.out.println(new Solution().countBalls(5, 15));
        System.out.println(new Solution().countBalls(19, 28));
    }
}

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[50];
        int ans = 0;
        while (lowLimit <= highLimit) {
            int sum = 0;
            for (int i = lowLimit; i != 0; i /= 10) sum += (i % 10);
            if (++count[sum] > ans) ans = count[sum];
            lowLimit++;
        }

        return ans;
    }
}