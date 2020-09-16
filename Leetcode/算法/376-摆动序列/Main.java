public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[] {1,7,4,9,2,5}));
        System.out.println(new Solution().wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));
        System.out.println(new Solution().wiggleMaxLength(new int[] {1,2,3,4,5,6,7,8,9}));
    }
}

class Solution {
    // 线性动态规划
    // 设两个数组，up, down
    // up 表示当前位置的最长上升序列的长度
    // down 表示当前位置的最长下降序列的长度
    //   如果下一个位置的元素 nums[i] 比当前位置的元素 nums[i-1] 大
    //   则下一个位置的最长上升序列长度是当前位置的最长下降序列长度加 1
    //   即 up[i] = down[i-1] + 1
    //   下一个位置的最长下降序列还是当前长度
    //   即 down[i] = down[i-1];

    //   如果下一个位置的元素 nums[i] 比当前位置的元素 nums[i-1] 小
    //   则下一个位置的最长下降序列长度是当前位置的最长上升序列长度加 1
    //   即 down[i] = up[i-1] + 1
    //   下一个位置的最长上升序列还是当前长度
    //   即 up[i] = up[i-1];

    //   如果相等，则两个最大值都不变
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[] down = new int[nums.length];
        int[] up = new int[nums.length];
        down[0] = 1;
        up[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }
            else if (nums[i-1] > nums[i]) {
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }

        return Math.max(up[nums.length-1], down[nums.length-1]);
    }
}