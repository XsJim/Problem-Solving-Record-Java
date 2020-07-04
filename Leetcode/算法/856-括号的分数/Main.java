import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfParentheses("()"));
        System.out.println(new Solution().scoreOfParentheses("(())"));
        System.out.println(new Solution().scoreOfParentheses("()()"));
        System.out.println(new Solution().scoreOfParentheses("(()(()))"));
    }
}

class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (char x : S.toCharArray()) {
            if (x == ')') {
                int top = stack.pop();
                top = (top == 0 ? 1 : 2 * top);
                if (stack.empty()) {
                    ans += top;
                } else {
                    stack.push(stack.pop()+top);
                }
            } else stack.push(0);
        }
        return ans;
    }
}