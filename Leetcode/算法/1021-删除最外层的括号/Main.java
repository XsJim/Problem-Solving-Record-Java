public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removeOuterParentheses("(()())(())"));
        System.out.println(new Solution().removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(new Solution().removeOuterParentheses("()()"));
    }
}

class Solution {
    public String removeOuterParentheses(String S) {
        boolean flag = true;
        char[] arr = S.toCharArray();
        StringBuilder ans = new StringBuilder();
        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '(') {
                if (flag) {
                    ans.append('(');
                    left++;
                } else flag = true;
            } else {
                if (left == 0) {
                    flag = false;
                } else {
                    ans.append(')');
                    left--;
                }
            }
        }
        return ans.toString();
    }
}