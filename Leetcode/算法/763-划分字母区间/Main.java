import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }
}

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] s = new int[26];
        for (int i = 0; i < 26; i++) s[i] = -1;
        int[] b = new int[26];

        for (int i = 0; i < S.length(); i++) {
            int x = (S.charAt(i)-'a');
            if (s[x] == -1) {
                s[x] = i;
            }
            b[x] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < S.length()) {
            int x = (S.charAt(i)-'a');
            int ts = s[x], tb = b[x];
            for (int j = ts + 1; j < tb; j++) {
                x = (S.charAt(j)-'a');
                if (b[x] > tb) tb = b[x];
            }
            ans.add(tb-ts+1);
            i = tb + 1;
        }

        return ans;
    }
}