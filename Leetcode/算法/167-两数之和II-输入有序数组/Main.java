import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {2, 3, 4}, 6)));
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (ans[0] = 1; ans[0] < numbers.length; ans[0]++) {
            int x = Arrays.binarySearch(numbers, ans[0], numbers.length, target-numbers[ans[0]-1]);
            if (x > 0) {
                ans[1] = x + 1;
                break;
            }
        }

        return ans;
    }
}