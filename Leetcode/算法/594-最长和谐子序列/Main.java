import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findLHS(new int[] {1,3,2,2,5,2,3,7}));
    }
}

class Solution {
    // 由于和谐子列满足的条件是序列中最大值和最小值的差是 1
    // 所以，满足条件的序列中只能有两类值： x, x + 1
    // 创建一个散列表，键为数字，值为数字出现的次数
    // 遍历给定数组，判断当前数字的自然数序列中的前后两个值在散列表是否存在，如果存在，则它们两组成的和谐序列的长度为它们两个当前数量的和
    // 返回这个值的最大值即可
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            int x = map.get(nums[i]);
            ans = Math.max(Math.max(ans, x + map.getOrDefault(nums[i]-1, -x)), x + map.getOrDefault(nums[i]+1, -x));
        }
        return ans;
    }
}