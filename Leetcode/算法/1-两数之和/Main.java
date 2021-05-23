import java.util.Arrays;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {3,2,4}, 6)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {3,3}, 6)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] ans = null;
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target-nums[i]);
            if (index != null && index != i) {
                ans = new int[] {i, index};
                break;
            }
            map.put(nums[i], i);
        }

        return ans;
    }
}