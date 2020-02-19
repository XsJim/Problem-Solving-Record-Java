import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().printNumbers(3)));
        System.out.println(Arrays.toString(new Solution().printNumbers(1)));
    }
}

class Solution {
    public int[] printNumbers(int n) {
        int m = 0;
        while (n != 0) {
            m *= 10;
            m += 9;
            n--;
        }
        int[] re = new int[m];
        for (int i = 0; i < m; i++) {
            re[i] = i + 1;
        }
        return re;
    }
}