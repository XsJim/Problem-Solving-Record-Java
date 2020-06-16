import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numUniqueEmails(new String[] {"test.email+alex@leetcode.com",
          "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            char[] sArr = s.toCharArray();
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] == '.') continue;
                if (sArr[i] == '+' || sArr[i] == '@') {
                    while (sArr[i] != '@') i++;
                    while (i < sArr.length) sb.append(sArr[i++]);
                    break;
                }
                sb.append(sArr[i]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}