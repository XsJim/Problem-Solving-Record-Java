import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new Solution().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new Solution().minRemoveToMakeValid("))(("));
        System.out.println(new Solution().minRemoveToMakeValid("(a(b(c)d)"));
    }
}

// 遍历字符串，建立一个栈
// 遇到左括号，将其下标推入栈中
// 遇到右括号，检测栈是否为空（是否有左括号和他匹配）
//   若为空，则这个右括号需要去掉，标记为 '*'
//   否则，从栈中弹出一个左括号下标
// 遍历完之后，将栈中残留的左括号下标在字符串中对应的位置都做标记 '*' ，这些左括号没有合适的右括号与之匹配，所以需要去掉
// 之后，遍历整个标记后的字符串，将非标记字符加入新的字符串中，得到答案
class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] ans = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else ans[i] = '*';
            }
            else if (ans[i] == '(') stack.push(i);
        }

        while (!stack.empty()) ans[stack.pop()] = '*';

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) if (ans[i] != '*') sb.append(ans[i]);

        return sb.toString();
    }
}