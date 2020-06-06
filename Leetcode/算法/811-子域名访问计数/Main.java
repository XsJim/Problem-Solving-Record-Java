import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
        System.out.println(new Solution().subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            char[] sArr = s.toCharArray();
            int i = 0, count = 0;
            while (sArr[i] != ' ') {
                count *= 10;
                count += (sArr[i]-'0');
                i++;
            }
            sArr[i] = '.';
            StringBuilder sb = new StringBuilder();
            for (int j = sArr.length - 1; j >= i; j--) {
                if (sArr[j] == '.') {
                    String key = new StringBuilder(sb).reverse().toString();
                    Integer x = map.get(key);
                    if (x == null) map.put(key, count);
                    else map.put(key, x+count);
                }
                sb.append(sArr[j]);
            }
        }
        List<String> list = new LinkedList<>();
        for (String s : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(s));
            sb.append(' ');
            sb.append(s);
            list.add(sb.toString());
        }
        return list;
    }
}