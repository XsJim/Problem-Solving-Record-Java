import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
        System.out.println(new Solution().validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2}));
    }
}

class Solution {
    // 确定出栈顺序是否正确，就要复原入栈顺序
    // 出栈的序列是有顺序的，所以遍历出栈序列，首先确定第一个出栈的元素
    // 确定之后，便在入栈序列中开始遍历，如果与要找的元素不同，就将它真实的入栈，直到找到该元素
    // 然后判断下一个
    // 这时由于栈中可能已经有元素存在，所以先判断栈顶元素是否是我们要找的元素，如果是，便可将其出栈并查找下一元素
    // 如果不是，说明该元素可能在栈的更深处，这说明出栈序列是错误的
    // 另一种情况是该元素可能还未入栈，所以需要继续遍历入栈序列，如果在剩余的序列中也没有找到该元素（下标达到数组长度），说明该出栈序列确实错误
    // 如果找到了该元素，说明当前的序列还是正确的
    // 当栈为空，或栈顶元素不为查找元素时，要确定出栈序列的正确性，就要继续将元素入栈
    // 当然，如果找到元素，那么当前的下标一定在数组范围内，但是当前元素已经确定，即没有入栈，且在之后的判断中已经不需要它，所以下标需要后移
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < popped.length; i++) {
            if (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
            } else {
                while (j < pushed.length && popped[i] != pushed[j]) {
                    stack.push(pushed[j]);
                    j++;
                }
                if (j == pushed.length) return false;
                j++;
            }
        }

        return true;
    }
}