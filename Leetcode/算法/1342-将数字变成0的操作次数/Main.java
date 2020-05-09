public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(14));
        System.out.println(new Solution().numberOfSteps(8));
        System.out.println(new Solution().numberOfSteps(123));
        System.out.println(new Solution().numberOfSteps(1000000));
    }
}

class Solution {
    public int numberOfSteps (int num) {
        int[] count = new int[1];
        talgo(count, num);
        return count[0];
    }

    private static void talgo(int[] count, int num) {
        if (num == 0) return;
        count[0]++;
        if (num % 2 == 0) talgo(count, num/2);
        else talgo(count, num-1);
    }
}