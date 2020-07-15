import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Solution().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
    }
}

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> mapB = new HashMap<>();
        

        char[] pArr = pattern.toCharArray();
        String[] sArr = str.split(" ");

        if (pArr.length != sArr.length) return false;
        for (int i = 0; i < pArr.length; i++) {
            if (map.containsKey(pArr[i]) ^ mapB.containsKey(sArr[i])) return false;
            if (map.containsKey(pArr[i])) {
                if (!map.get(pArr[i]).equals(sArr[i]) || mapB.get(sArr[i]) != pArr[i]) return false;
            } else {
                map.put(pArr[i], sArr[i]);
                mapB.put(sArr[i], pArr[i]);
            }
        }

        return true;
    }
}