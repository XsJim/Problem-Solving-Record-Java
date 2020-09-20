public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().modifyString("?zs"));
        System.out.println(new Solution().modifyString("ubv?w"));
        System.out.println(new Solution().modifyString("j?qg??b"));
        System.out.println(new Solution().modifyString("??yw?ipkj?"));
    }
}

class Solution {
    // 遇到问号，就找一个和他两端字符不同的字母填入
    // 返回最终字符数组的字符串形式即可
    public String modifyString(String s) {
        char[] sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == '?') {
                char l = i - 1 >= 0 ? sArr[i-1] : '?';
                char r = i + 1 < sArr.length ? sArr[i+1] : '?';
                sArr[i] = getChar(l, r);
            }
        }

        return new String(sArr);
    }

    private static char getChar(char l, char r) {
        if (l != 'a' && r != 'a') return 'a';
        if (l != 'b' && r != 'b') return 'b';
        return 'c';
    }
}