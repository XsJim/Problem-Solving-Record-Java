public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().compressString("aabcccccaaa"));
        System.out.println(new Solution().compressString("abbccd"));
        System.out.println(new Solution().compressString("bb"));
    }
}

class Solution {
    public String compressString(String S) {
        if (S.length() == 0) return S;
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            char nowCheck = chars[i++];
            int count = 1;
            while (i < chars.length && chars[i] == nowCheck) {
                count++;
                i++;
            }
            sb.append(nowCheck);
            sb.append(count);
            if (sb.length() >= S.length()) return S;
        }
        return sb.toString();
    }
}