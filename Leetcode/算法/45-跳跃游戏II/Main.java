public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[] {2,3,1,1,4}));
        System.out.println(new Solution().jump(new int[] {2,3,0,1,4}));
    }
}


// 数组元素表示最大的跳跃步数，假设当前处于位置 x ：
//   1. 如果从此位置跳跃最大步数可以略过最后一个位置（可达），那么无需后续步骤，只需从当前位置再跳一次便可到达终点
//   2. 若不满足情况一，就需要确定接下来跳到那个位置会使总的步数最少：
//     1. 首先，下一步可达位置当前已经可以确定，它们由 x 的下一个元素开始，直到 x + [x位置可跳跃的最大步数] 为止
//     2. 依次遍历这些可达元素，对每个元素计算从它可以到达的最远距离，选择所有这些点中，可达最远距离最大的那个点作为当前点的下一跳位置（使下一次选择的范围最优，可选的新的点更多）
//   3. 不断选择、跳跃，直到满足条件一
class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (i + nums[i] >= nums.length - 1) {
                count++;
                break;
            }
            int j = i + 1;

            int can = i + nums[i];
            int max_can = -1;
            int max_can_index = -1;
            while (j < nums.length && j <= can) {
                int c = nums[j] + j;

                if (c >= max_can) {
                    max_can = c;
                    max_can_index = j;
                }
                j++;
            }

            i = max_can_index;
            count++;
        }

        return count;
    }
}