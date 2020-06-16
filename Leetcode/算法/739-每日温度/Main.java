import java.util.Stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.empty() && T[stack.peek()] < T[i]) {
                int j = stack.pop();
                ans[j] = i - j;
            }
            stack.add(i);
        }
        return ans;
    }
}