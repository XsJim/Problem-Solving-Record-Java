import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});

        for (List<String> list : lists) {
            for (String str : list) {
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new LinkedList<List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if (list == null) {
                list = new LinkedList<String>();
                map.put(key, list);
                ans.add(list);
            }
            list.add(strs[i]);
        }
        return ans;
    }
}