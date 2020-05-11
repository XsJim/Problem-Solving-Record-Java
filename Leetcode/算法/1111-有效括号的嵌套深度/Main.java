import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxDepthAfterSplit("(()())")));
        System.out.println(Arrays.toString(new Solution().maxDepthAfterSplit("()(())()")));
    }
}

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        char[] seqs = seq.toCharArray();
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        for (int i = 0; i < seqs.length; i++) {
            if (seqs[i] == '(') {
                if (stack1.size() <= stack2.size()) {
                    stack1.push(0);
                    ans[i] = 0;
                } else {
                    stack2.push(0);
                    ans[i] = 1;
                }
            } else {
                if (stack1.size() > stack2.size()) {
                    stack1.pop();
                    ans[i] = 0;
                } else {
                    stack2.pop();
                    ans[i] = 1;
                }
            }
        }
        return ans;
    }
}