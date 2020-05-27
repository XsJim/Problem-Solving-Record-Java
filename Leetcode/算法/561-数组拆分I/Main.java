public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().arrayPairSum(new int[] {1,4,3,2}));
    }
}

class Solution {
    public int arrayPairSum(int[] nums) {
        int[] count = new int[20001];
        int p = 10000;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]+p]++;
        }
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i <= 20000; i++) {
            if (count[i] > 0) {
                if (flag) {
                    if (count[i] % 2 == 0) {
                        sum += (count[i] / 2) * (i-p);
                    } else {
                        sum += (count[i] / 2 + 1) * (i-p);
                        flag = false;
                    }
                } else {
                    sum += (count[i] / 2) * (i-p);
                    if (count[i] % 2 != 0) flag = true;
                }
            }
        }
        return sum;
    }
}