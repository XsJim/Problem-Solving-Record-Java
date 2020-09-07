import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[] {1,2,2,4})));
    }
}

class Solution {
    // 建立映射数组
    // 遍历给定的数组，对每个出现的数字进行计数
    // 遍历映射数组，分别记录下出现两次和出现一次的数字
    // 返回答案
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int[] ans = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0) ans[1] = i;
            else if (count[i] == 2) ans[0] = i;
        }

        return ans;
    }
}