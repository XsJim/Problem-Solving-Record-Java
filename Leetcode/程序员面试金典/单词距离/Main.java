import java.util.HashMap;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findClosest(new String[] {"I","am","a","student","from","a","university","in","a","city"}, "a", "student"));
    }
}

class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        HashMap<String, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            LinkedList<Integer> list = map.get(words[i]);
            if (list == null) {
                list = new LinkedList<>();
                map.put(words[i], list);
            }
            list.add(i);
        }
        LinkedList<Integer> list1 = map.get(word1);
        LinkedList<Integer> list2 = map.get(word2);
        if (list1 == null || list2 == null) return -1;
        int ans = 1000000;
        for (Integer i : list1) {
            for (Integer j : list2) {
                int s = Math.abs(i-j);
                if (s < ans) ans = s;
            }
        }
        return ans;
    }
}