import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {1,2,3})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {4,3,2,1})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {9,9,9,9})));
    }
}

class Solution {
    // 末位加一，关键在于进位
    // 设置一个进位值，初始值为 1 ，从末位开始逐位向上加
    // 先给当前位加上进位值，再将当前位的十位数字赋予进位，再将当前位的个位赋予当前位，完成一次加法
    // 判断进位是否为 0 ，如果为 0 ，则不需要再继续进行，且原数组中保存的就是答案
    // 进位不为 0 ，则判断原数组的数字是否已经加完（下标是否为 -1），如果已经加完，说明当前的进位是需要新增的一位
    // 是否需要新增进位，是由进位数字是否为 0 所决定的，与原数组是否加完无关
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int k = 1;
        while (k != 0 && i >= 0) {
            digits[i] += k;
            k = digits[i] / 10;
            digits[i] %= 10;
            i--;
        }

        if (k != 0) {
            int[] ans = new int[digits.length+1];
            i = 0;
            ans[i++] = k;
            for (int j = 0; j < digits.length; j++, i++) ans[i] = digits[j];
            return ans;
        }

        return digits;
    }
}