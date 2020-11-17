import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decrypt(new int[] {5,7,1,4}, 3)));
        System.out.println(Arrays.toString(new Solution().decrypt(new int[] {1,2,3,4}, 0)));
        System.out.println(Arrays.toString(new Solution().decrypt(new int[] {2,4,9,3}, -2)));
    }
}

// 首先计算数组前缀和
// 然后遍历密码数组，分情况计算得到每一个数的明文
class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) return new int[code.length];
        int len = code.length;
        int[] sum = new int[len];
        int x = len - 1;
        sum[x] = code[x];
        while (--x >= 0) {
            sum[x] = code[x] + sum[x+1];
        }
        
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int c = i + k;
            if (c < 0) ans[i] = sum[0] - sum[i] + sum[len+c];
            else if (c >= len) ans[i] =  sum[i] - code[i] + sum[0] - sum[c-len+1];
            else {
                if (k > 0) ans[i] = sum[i+1] - (c == len - 1 ? 0 : sum[c+1]);
                else ans[i] = sum[c] - sum[i];
            }
        }

        return ans;

    }
}