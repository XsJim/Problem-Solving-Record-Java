import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().permutation("qqe")));
        System.out.println(Arrays.toString(new Solution().permutation("ab")));
    }
}

class Solution {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] flag = new boolean[chars.length];
        LinkedList<String> list = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            flag[i] = true;
            talgo(map, flag, chars, list, chars[i]+"");
            flag[i] = false;
        }

        return list.toArray(new String[list.size()]);
    }

    private static void talgo(HashMap<String, Integer> map, boolean[] flag, char[] chars, LinkedList<String> list, String str) {
        if (chars.length == str.length()) {
            if (!map.containsKey(str)) {
                list.add(str);
                map.put(str, 1);
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                talgo(map, flag, chars, list, str+chars[i]);
                flag[i] = false;
            }
        }
    }
}