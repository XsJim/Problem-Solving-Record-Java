public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findNumbers(new int[] {12,345,2,6,7896}));
        System.out.println(new Solution().findNumbers(new int[] {555,901,482,1771}));
    }
}

class Solution {
    public int findNumbers(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count(nums[i]) % 2 == 0) sum++;
        }
        return sum;
    }

    private static int count(int num) {
        int sum = 0;
        while (num != 0) {
            sum++;
            num /= 10;
        }
        return sum;
    }
}