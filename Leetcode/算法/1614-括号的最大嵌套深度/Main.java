public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(new Solution().maxDepth("(1)+((2))+(((3)))"));
        System.out.println(new Solution().maxDepth("1+(2*3)/(2-1)"));
        System.out.println(new Solution().maxDepth("1"));
    }
}

class Solution {
    // 模仿栈检查最大括号嵌套深度
    public int maxDepth(String s) {
        int ans = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
                ans = Math.max(ans, l);
            }
            else if (s.charAt(i) == ')') l--;
        }

        return ans;
    }
}