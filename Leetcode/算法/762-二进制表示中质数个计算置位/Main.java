public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countPrimeSetBits(6, 10));
        System.out.println(new Solution().countPrimeSetBits(10, 15));
    }
}

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int sum = 0;
        boolean[] flag = new boolean[] {false, true, false, false, true,
          false, true, false, true, true, true, false, true, false, true,
          true, true, false, true, false, true, true, true, false, true};
        while (L <= R) {
            int i = L, count = 0;
            while (i != 0) {
                count++;
                i &= (i - 1);
            }
            if (!flag[count]) sum++;
            L++;
        }
        return sum;
    }
}