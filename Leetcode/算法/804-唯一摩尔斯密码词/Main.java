import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
    }
}

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] wordBook = new String[] {".-","-...","-.-.","-..",".",
           "..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
           ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--",
           "--.."};
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(wordBook[c-'a']);
            }
            String ans = sb.toString();
            if (map.get(ans) == null) {
                map.put(ans, true);
                count++;
            }
        }
        return count;
    }
}