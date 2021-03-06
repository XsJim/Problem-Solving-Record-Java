import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> items = List.of(
            List.of("phone","blue","pixel"),
            List.of("computer","silver","lenovo"),
            List.of("phone","gold","iphone")
        );

        System.out.println(new Solution().countMatches(items, "color", "silver"));
    }
}

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        String[] key = new String[] {"type", "color", "name"};
        int keyIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(ruleKey)) {
                keyIndex = i;
                break;
            }
        }

        for (List<String> list : items) {
            if (list.get(keyIndex).equals(ruleValue)) {
                ans++;
            }
        }

        return ans;
    }
}