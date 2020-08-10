public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution().decodeString("abc3[cd]xyz"));
    }
}

class Solution {
    // 数据可能有嵌套，而且嵌套可能不止一层，所以使用递归来做比较方便
    // 设有一方法，用来对给定的字符串进行解码
    // 对于内部嵌套快，单独将其取出，也可看作一个可解码的字符串，也需要同样的方法进行解码
    // 对于最外层的块，结束解码的条件是解码位置到达字符串末尾
    // 对于内层的块，结束的条件是解码位置到达关闭当前块的符号 ']'
    // 一个块被解码之后，还可能是需要复写的，这个复写次数是由外层块决定的，而这个数字也可以作为接下来有一个嵌套快的标记
    // 所以在方法中，遇到数字，就表示接下来要进入嵌套快，首先计算出数字，再得到之后的嵌套块代表的字符串，然后循环添加到答案中
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        talgo(s.toCharArray(), 0, sb, true);
        return sb.toString();
    }

    private static boolean check(char[] sArr, int i, boolean flag) {
        if (flag) return i < sArr.length;
        return sArr[i] != ']';
    }

    private static int talgo(char[] sArr, int i, StringBuilder sb, boolean flag) {
        while (check(sArr, i, flag)) {
            if (sArr[i] >= '0' && sArr[i] <= '9') {
                int x = 0;
                while (sArr[i] != '[') {
                    x *= 10;
                    x += (sArr[i]-'0');
                    i++;
                }
                StringBuilder sInner = new StringBuilder();
                i = talgo(sArr, i+1, sInner, false);
                String current = sInner.toString();
                while (x-- > 0) sb.append(current);
            } else {
                sb.append(sArr[i]);
                i++;
            }
        }
        return i+1;
    }
}