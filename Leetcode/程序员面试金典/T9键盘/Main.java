import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<String> list = new Solution().getValidT9Words("8733", new String[] {"tree", "used"});
        for (String string : list) {
            System.out.print(string + " ");
        }
        list = new Solution().getValidT9Words("2", new String[] {"a", "b", "c", "d"});
        System.out.println();
        for (String string : list) {
            System.out.print(string + " ");
        }
    }
}

class Solution {
    private static char[] nums = new char[] {'2', '2', '2', '3', '3', '3',
           '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7',
           '7', '7', '8', '8', '8', '9', '9', '9', '9'};

    public List<String> getValidT9Words(String num, String[] words) {
        if (num == null || words == null) return null;
        
        List<String> linkedList = new LinkedList<>();
        char[] numChars = num.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (wordNumEqualsNum(words[i], nums, numChars)) {
                linkedList.add(words[i]);
            }
        }

        return linkedList;
    }

    private static boolean wordNumEqualsNum(String word, char[] nums, char[] numChars) {
       char[] wordChars = word.toCharArray();
       
       for (int i = 0; i < wordChars.length; i++) {
           if (numChars[i] != nums[wordChars[i]-'a']) {
               return false;
           }
       }

       return true;
    }
}