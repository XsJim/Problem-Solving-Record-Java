import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPossibleDivide(new int[] {1,2,3,3,4,4,5,6}, 4));
        System.out.println(new Solution().isPossibleDivide(new int[] {3,2,1,2,3,4,3,4,5,9,10,11}, 3));
        System.out.println(new Solution().isPossibleDivide(new int[] {3,3,2,2,1,1}, 3));
        System.out.println(new Solution().isPossibleDivide(new int[] {1,2,3,4}, 3));
    }
}

class Solution {
    // 如果给定数组的长度不能完整的分为 k 对，说明该数组不能通过条件
    // 如果数组内数字的范围小一点：
    // 可以建立一个长度为最大可能数字加一的数组
    // 然后遍历给定数组，对每个数字进行计数
    // 再次遍历计数数组，如果当前位置数字不为 0 ，则开始进入内部判断
    // 内部判断负责从该位置向后，每次都是当前数字加一，如果要查找的数字可用数量为 0 ，且当前已组合的长度没有达到 k ，说明这个数组不符合条件
    // 如果要查找的数字可用数量不为 0 ，说明可以继续查找
    // 如此遍历整个计数数组，直到所有计数都为 0 ，或中途出现不符合条件的组合
    // 题目要求的数字范围较大，不能使用数组来计数
    // 算法的要求是，知道数字的可用数量，且可以按序判断，所以使用可按照键值排序的散列表来替代计数数组
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (int i : map.keySet()) {
            while (map.get(i) != 0) {
                map.put(i, map.get(i)-1);
                for (int j = 1, x = i + 1; j < k; j++, x++) {
                    Integer current = map.get(x);
                    if (current == null || current == 0) return false;
                    map.put(x, current-1);
                }
            }
        }

        return true;
    }
}