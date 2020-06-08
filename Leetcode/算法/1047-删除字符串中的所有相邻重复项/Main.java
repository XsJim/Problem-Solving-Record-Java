public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));
        System.out.println(new Solution().removeDuplicates("aa"));
    }
}

class Solution {
    public String removeDuplicates(String S) {
        char[] sArr = S.toCharArray();
        int i = 0, j = 1;
        while (j < sArr.length) {
            if (sArr[i] == sArr[j]) {
                sArr[i] = '.';
                sArr[j] = '.';
                j++;
                while (i > 0 && sArr[i] == '.') i--;
                if (i == -1) {
                    i = j;
                    j++;
                }
            } else {
                i = j;
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char x : sArr) {
            if (x != '.') sb.append(x);
        }
        return sb.toString();
    }
}