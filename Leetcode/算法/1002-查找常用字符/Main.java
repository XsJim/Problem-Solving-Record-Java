import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[] {"bella","label","roller"}));
        System.out.println(new Solution().commonChars(new String[] {"cool","lock","cook"}));
    }
}

class Solution {
    public List<String> commonChars(String[] A) {
        int[] ans = new int[26];
        tCount(ans, A[0]);
        for (int i = 1; i < A.length; i++) {
            int[] count = new int[26];
            tCount(count, A[i]);
            for (int j = 0; j < 26; j++) {
                ans[j] = ans[j] < count[j] ? ans[j] : count[j];
            }
        }

        List<String> list = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            while (ans[i]-- > 0) {
                list.add(String.valueOf((char)(i+'a')));
            }
        }
        return list;
    }

    private static void tCount(int[] count, String s) {
        for (char x : s.toCharArray()) count[x-'a']++;
    }
}