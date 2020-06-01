import java.util.Arrays;

import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"})));
    }
}

class Solution {
    public String[] findWords(String[] words) {
        String a = "qwertyuiop";
        String b = "asdfghjkl";
        String c = "zxcvbnm";
        int[] flag = new int[26];
        for (char x : a.toCharArray()) flag[x-'a'] = 1;
        for (char x : b.toCharArray()) flag[x-'a'] = 2;
        for (char x : c.toCharArray()) flag[x-'a'] = 3;

        List<String> list = new LinkedList<>();
        for (String s : words) {
            if (s.length() > 0) {
                char[] sArr = s.toCharArray();
                int index = sArr[0] - 'a';
                if (sArr[0] >= 'A' && sArr[0] <= 'Z') index = sArr[0] - 'A';
                int x = flag[index];
                boolean flag_2 = false;
                for (int i = 1; i < sArr.length; i++) {
                    if (sArr[i] >= 'A' && sArr[i] <= 'Z') index = sArr[i] - 'A';
                    else index = sArr[i] - 'a';
                    if (flag[index] != x) {
                        flag_2 = true;
                        break;
                    }
                }
                if (!flag_2) list.add(s);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}