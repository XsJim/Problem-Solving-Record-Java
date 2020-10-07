public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().thousandSeparator(987));
        System.out.println(new Solution().thousandSeparator(1234));
        System.out.println(new Solution().thousandSeparator(123456789));
        System.out.println(new Solution().thousandSeparator(0));
    }
}

class Solution {
    // 统计数字长度，计算需要添加 '.' 的数量
    // 创建对应长度的字符数组
    // 逐位向字符数组中添加数字和 '.'
    // 将添加好的字符数组转换成字符串并返回
    public String thousandSeparator(int n) {
        int len = 1;
        int x = n / 10;
        while (x != 0) {
            len++;
            x /= 10;
        }
        int d = (int)Math.ceil(len / 3.0) - 1;
        char[] ans = new char[len+d];
        int i = ans.length - 1;
        int count = 0;
        while (i >= 0) {
            if (count == 3) {
                ans[i--] = '.';
                count = 0;
            } else {
                ans[i--] = (char)((n % 10) + '0');
                n /= 10;
                count++;
            }
        }
        return new String(ans);
    }
}