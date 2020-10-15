import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().specialArray(new int[] {3,5}));
        System.out.println(new Solution().specialArray(new int[] {0,0}));
        System.out.println(new Solution().specialArray(new int[] {0,4,3,0,4}));
        System.out.println(new Solution().specialArray(new int[] {3,6,7,7,0}));
    }
}

// 首先将数组排序
// 然后从 1 开始枚举可能的 x 值
// 例如 x = 1
// 意思是数组中只有 1 个数大于或等于 1
// 由于数组已经排序，所以只需要观察数组中的最后一个数是否大于等于 1
// 以及最后一个数的前一个数是否存在，和它是否比 1 小
// 逐渐将 x 加一，对每个 x ，最多只需判断数组中的两位相邻的数即可
// 如果对某一个 x ，两位数的条件都满足，那么这个 x 就是满足条件的
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            boolean flag = true;
            if (nums[nums.length-i] < i) flag = false;
            if (flag && nums.length-i-1 >= 0 && nums[nums.length-i-1] >= i) flag = false;
            if (flag) return i;
        }

        return -1;
    }
}