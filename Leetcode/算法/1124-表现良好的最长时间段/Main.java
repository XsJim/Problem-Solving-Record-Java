import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestWPI(new int[] {9,9,6,0,6,6,9}));
        System.out.println(new Solution().longestWPI(new int[] {6,6,9}));
    }
}

// -前缀和
// -单调栈
// 首先，遍历给定数组，如果当天工作时间大于 8 小时，将这个位置标记为 1 ，否则标记为 -1
// 遍历之后得到一个数组（改变后），元素为 1 表示当天表现良好，为 -1 则表示当天表现不良好
// 取一段任意长的子区间，如果该区间中 1 的个数多于 -1 的个数，则说明这段区间是“表现良好”的，且这个区间的长度是区间尾下标减去区间头下标加 1
// 如果一段区间中 1 的个数多于 -1 ，那么这段区间的和必定大于 0
// 这时，可以将题目所求问题改变为：求改变后数组中，区间和大于 0 的区间的最大区间长度
// 为了更方便计算每段区间的和，可以计算出一个前缀和数组，前缀和数组比改变后数组多一个元素，这个元素位于前缀和数组头部，值为 0 ，表示改变后数组的前 0 个元素的和
// 这之后的每一个元素，都于改变后数组元素一一对应，表示该元素和该元素之前所有元素的和
// 为了快速计算出区间和大于 0 的最大区间长度，使用一个单调递增栈（内部元素从栈顶到栈底递增）
// 首先填充栈，前缀和数组首元素下标先入栈（使用下标为了之后计算区间长度），然后依次向后遍历，确保入栈下标对应的元素是逐渐减小的（那么出栈时便是递增的）
// 要计算出最长区间长度，需要再次遍历前缀和数组，这次需要逆序遍历
// 如果当前前缀和元素大于栈顶下标对应元素，说明使用它们作为头尾的区间和是大于 0 的，也就是满足了条件的区间
// 之后计算区间长度，将最大值替换为当前最大值和当前区间长度的最大值（首次最大值取 0 ，防止区间长度为负数）

class Solution {
    public int longestWPI(int[] hours) {
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) hours[i] = 1;
            else hours[i] = -1;
        }

        int[] presum = new int[hours.length+1];
        for (int i = 1; i <= hours.length; i++) {
            presum[i] = presum[i-1] + hours[i-1];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < presum.length; i++) {
            if (presum[i] < presum[stack.peek()]) stack.push(i);
        }

        int ans = 0;
        for (int i = presum.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && presum[i] > presum[stack.peek()]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }

        return ans;
    }
}