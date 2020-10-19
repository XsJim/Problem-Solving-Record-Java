public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new String[] {"d1/","d2/","../","d21/","./"}));
        System.out.println(new Solution().minOperations(new String[] {"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(new Solution().minOperations(new String[] {"d1/","../","../","../"}));
    }
}

// 模拟一个栈
// 当遇到进入文件夹操作时，栈的深度加一
// 当遇到返回父文件夹操作时，判断栈深度是否为 0 ，不为 0 则深度减 1
class Solution {
    public int minOperations(String[] logs) {
        int stack = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].charAt(0) != '.') stack++;
            else {
                if (logs[i].length() == 3) {
                    if (stack != 0) stack--;
                }
            } 
        }

        return stack;
    }
}