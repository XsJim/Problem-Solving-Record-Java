import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] map = new char[256];
        map['('] = ')'; map['['] = ']'; map['{'] = '}';
        for (char x : s.toCharArray()) {
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
            } else {
                if (stack.empty()) return false;
                if (map[stack.pop()] != x) return false;
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
}