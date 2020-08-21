public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
    }
}

class Solution {
    // 给一数字 a ，从字符串起始处，取长为 2*a 的一段，将这段中的前 a 个字符反转
    // 起始处为 0 ，每次处理的区间起始位置通过增加 2*a 的到
    // 得到起始位置后，便可计算要反转的区间的最后一个字符的位置
    // 计算出这个值，就可以确定它是否在给定字符串长度外，如果超出了，就将剩余的字符串反转，这时需要将这最后一位改为字符串的最后一位
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int a = k * 2;
        for (int i = 0; i < sArr.length; i += a) {
            int j = i, z = i + k - 1;
            if (z >= sArr.length) z = sArr.length - 1;
            while (j < z) {
                char temp = sArr[j];
                sArr[j++] = sArr[z];
                sArr[z--] = temp;
            }
        }

        return new String(sArr);
    }
}