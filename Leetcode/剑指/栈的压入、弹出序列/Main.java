public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
        System.out.println(new Solution().validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2}));
    }
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int j = 0, stackTop = 0;
        for (int i : pushed) {
            stack[stackTop] = i;
            while (stackTop >= 0 && stack[stackTop] == popped[j]) {
                stackTop--;
                j++;
            }
            stackTop++;
        }
        return (stackTop == 0);
    }
}