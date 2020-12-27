import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().halvesAreAlike("book"));
        System.out.println(new Solution().halvesAreAlike("textbook"));
        System.out.println(new Solution().halvesAreAlike("MerryChristmas"));
        System.out.println(new Solution().halvesAreAlike("AbCdEfGh"));
    }
}

// 创建映射以便后续对元音字母计数
// 分别记录前后两段元音字母数量
// 返回两段字母数量是否相同
class Solution {
    public boolean halvesAreAlike(String s) {
        Map<Character, Integer> map = Map.of(
            'a', 1,
            'e', 1,
            'i', 1,
            'o', 1,
            'u', 1,
            'A', 1,
            'E', 1,
            'I', 1,
            'O', 1,
            'U', 1
        );
        int l = 0, r = 0;
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
            if (map.get(s.charAt(i)) != null) l++;
        }

        for (int i = half; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) r++;
        }

        return l == r;
    }
}