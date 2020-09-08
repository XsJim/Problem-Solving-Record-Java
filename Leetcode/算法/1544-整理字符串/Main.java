public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().makeGood("leEeetcode"));
        System.out.println(new Solution().makeGood("abBAcC"));
        System.out.println(new Solution().makeGood("s"));
    }
}

class Solution {
    // 模仿一个栈
    // 从字符串的第一个字符开始入栈
    // 如果当前入栈字符和当前栈顶字符满足删除条件，则将栈顶元素删除，且将当前入栈字符抛开
    // 重复这一过程直到所有字符均完成入栈检测，栈内剩余的字符就是所求答案
    public String makeGood(String s) {
        char[] sArr = s.toCharArray();
        int[] lastTop = new int[sArr.length];
        lastTop[0] = -1; 
        int i = 0, top = -1;
        while (i < sArr.length) {
            if (top == -1) {
                lastTop[i] = top;
                top = i;
            } else {
                if (check(sArr[i], sArr[top])) {
                    sArr[i] = '*';
                    sArr[top] = '*';
                    top = lastTop[top];
                } else {
                    lastTop[i] = top;
                    top = i;
                }
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < sArr.length; j++) {
            if (sArr[j] != '*') sb.append(sArr[j]);
        }

        return sb.toString();
    }

    private static boolean check(char a, char b) {
        if (a == b) return false;
        return up(a) == up(b);
    }

    private static char up(char x) {
        if (x >= 'A' && x <= 'Z') return x;
        return (char)(x-'a'+'A');
    }
}