import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
        System.out.println(new Solution().letterCasePermutation("3z4"));
        System.out.println(new Solution().letterCasePermutation("12345"));
    }
}

class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] s = S.toCharArray();
        List<String> list = new LinkedList<>();
        talgo(s, 0, list);
        return list;
    }

    private static void talgo(char[] s, int i, List<String> list) {
        if (i == s.length) {
            list.add(new String(s));
            return;
        }
        talgo(s, i+1, list);
        if (s[i] >= '0' && s[i] <= '9') return;
        if (s[i] >= 'a' && s[i] <= 'z') {
            s[i] = (char)(s[i] - 'a' + 'A');
        } else {
            s[i] = (char)(s[i] - 'A' + 'a');
        }
        talgo(s, i+1, list);
    }
}