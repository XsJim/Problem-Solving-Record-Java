public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numSteps("1101"));
        System.out.println(new Solution().numSteps("10"));
        System.out.println(new Solution().numSteps("1"));
    }
}

class Solution {
    // 一个二进制数除以二，就是数字左移一位，高位用 0 填补
    // 采用模拟的方式，来计算给定数字变为 1 所需的步骤
    // 将给定数字从高位到低位填充入一个栈中
    // 然后循环检查当前栈顶元素（停止条件是栈顶和栈底指向同一位置，即只剩下 1 ）
    // 如果栈顶为 0 ，说明当前数字是偶数，直接将这个 0 弹出
    // 如果栈顶为 1 ，说明当前数字为奇数，需要做加 1 操作
    // 这时从低位至高位逐位判断是否需要变换，可能出现的情况是，到达最高位后，依然有进位，这就需要对栈底进行扩展，以便存放这多出来的一位 1
    // 在循环中，栈顶的下移只发生在栈顶元素为 0 时，为 1 时，栈顶的数字改变，需要继续判断
    // 循环的总数，就是所求答案
    public int numSteps(String s) {
        char[] cArr = new char[s.length()+1];
        for (int i = 0, j = 1; j < cArr.length; j++, i++) {
            cArr[j] = s.charAt(i);
        }

        int top = cArr.length - 1;
        int d = 1;
        int sum = 0;
        while (d != top) {
            if (cArr[top] == '1') {
                int x = top;
                int j = 1;
                while (j != 0) {
                    if (cArr[x] == '1') {
                        cArr[x] = '0';
                    } else {
                        cArr[x] = '1';
                        j = 0;
                    }
                    x--;
                }
                if (x == -1) d = 0;
            } else top--;
            sum++;
        }
        return sum;
    }
}