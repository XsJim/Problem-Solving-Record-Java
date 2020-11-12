import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abcd", 2));
        System.out.println(new Solution().removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(new Solution().removeDuplicates("pbbcggttciiippooaais", 2));
    }
}

// 建立两个栈
// 一个用来放字符，一个用来放计数数字
// 计数数字栈中，每个元素和字符栈中元素一一对应
// 表示当前字符的重复次数（即在字符串中，当前字符前边，且与它通过相同字符连接的字符数目）
// 遍历字符串，变量 j 记录的就是除去当前字符，与它相接的相同字符的数目
// 如果当前字符和栈顶字符相同，则说明当前字符已经连续出现，那么变量 j +1;
// 否则，说明当前字符左边相连位置没有和它相同的字符，这时 j 归为 1
// 之后，将当前字符加入字符栈，当前的 j 加入计数栈
// 然后判断 j 的值是否等于 k
// 如果等于，则说明应该删除字符了，就从两个栈中弹出 k 个元素，且当前的计数数字 j 变为弹出元素之后的计数栈的栈顶元素
// 否则，连续出现的数量还没有达到要求
// 遍历完整个字符串之后，字符栈中保存的便是所求的答案，从栈底开始组合字符串，返回即可
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackCount = new Stack<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char cc = stack.empty() ? '*' : stack.peek();
            char ccc = s.charAt(i);
            
            if (ccc == cc) {
                j++;
            } else {
                j = 1;
            }
            stack.push(ccc);
            stackCount.push(j);
            if (j == k) {
                while (j != 0) {
                    stack.pop();
                    stackCount.pop();
                    j--;
                }
                j = stackCount.empty() ? 0 : stackCount.peek();
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(x->sb.append(x));
        return sb.toString();
    }
}