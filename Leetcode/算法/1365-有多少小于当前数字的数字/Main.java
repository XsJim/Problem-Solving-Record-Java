import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(new int[] {8,1,2,2,3})));
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(new int[] {6,5,4,8})));
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(new int[] {7,7,7,7})));

    }
}

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int[] numsC = new int[nums.length];
        for (int i = 0; i < nums.length; i++) numsC[i] = nums[i];
        Arrays.sort(numsC);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (numsC[j] < nums[i]) ans[i]++;
                else break;
            }
        }
        return ans;
    }
}