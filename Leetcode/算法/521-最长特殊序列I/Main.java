public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength("aba", "cdc"));
        System.out.println(new Solution().findLUSlength("aaa", "bbb"));
        System.out.println(new Solution().findLUSlength("aaa", "aaa"));
    }
}

// 看官方题解：
// 字符串a, b的关系有三种：
// a == b ：这种情况下，没有最长特殊序列存在
// a != b && a.length() == b.length() ：这种情况下，选取某个字符串的全部，就不可能是另一个的子序列，所以返回它的长度即可
// a.length() != b.length() ：这种情况下，只要选取较长字符串的全部，就不可能是另一个的子序列，所以返回这个最长长度即可
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}