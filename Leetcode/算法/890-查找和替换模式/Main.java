import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findAndReplacePattern(new String[] {"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] flag = new int[26];
        int[] p = new int[pattern.length()];
        int x = 0; int i = 0;
        while (i < 26) flag[i++] = -1;
        i = 0;
        for (char c : pattern.toCharArray()) {
            if (flag[c-'a'] == -1) {
                p[i] = x;
                flag[c-'a'] = x;
                x++;
            } else {
                p[i] = flag[c-'a'];
            }
            i++;
        }
        List<String> list = new LinkedList<>();
        for (String s : words) {
            i = 0;
            while (i < 26) flag[i++] = -1;
            i = 0; x = 0;
            boolean b = true;
            for (char c : s.toCharArray()) {
                if (flag[c-'a'] == -1) {
                    flag[c-'a'] = x;
                    x++;
                }
                if (p[i] != flag[c-'a']) { b = false; break; }
                i++;
            }
            if (b) list.add(s);
        }
        return list;
    }
}