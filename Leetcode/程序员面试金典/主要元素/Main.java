import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[] {1,2,5,9,5,9,5,5,5}));
        System.out.println(new Solution().majorityElement(new int[] {3,2}));
        System.out.println(new Solution().majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer x = map.get(nums[i]);
            if (x == null) {
                map.put(nums[i], 1);
                x = 1;
            } else {
                map.put(nums[i], x+1);
                x++;
            }
            if (x > nums.length / 2) {
                max = nums[i];
            }
        }
        return max;
    }
}