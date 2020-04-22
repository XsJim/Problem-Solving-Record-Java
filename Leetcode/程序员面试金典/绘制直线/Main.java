import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().drawLine(1, 32, 30, 31, 0)));
        System.out.println(Arrays.toString(new Solution().drawLine(3, 96, 0, 95, 0)));
    }
}

class Solution {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ans = new int[length];
        int b = x1 + y * w;
        int e = x2 + y * w;
        int x = 0b10000000000000000000000000000000;
        int i = b / 32;
        int j = i * 32;
        while (j < b) {
            x >>>= 1;
            j++;
        }
        while (b <= e) {
            ans[i] |= x;
            b++; j++;
            x >>>= 1;
            if (j % 32 == 0) {
                x = 0b10000000000000000000000000000000;
                i++;
            }
        }
        return ans;
    }
}