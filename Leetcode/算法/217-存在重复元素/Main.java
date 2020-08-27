import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().containsDuplicate(new int[] {1,2,3,1}));
        System.out.println(new Solution().containsDuplicate(new int[] {1,2,3,4}));
        System.out.println(new Solution().containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }
}

class Solution {
    // 线性查找超时
    // 普通的数组散列对存在较大整数的情况无法处理
    // 所以使用 Java 的 HashMap 来进行映射
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], 1);
        }

        return false;
    }
}