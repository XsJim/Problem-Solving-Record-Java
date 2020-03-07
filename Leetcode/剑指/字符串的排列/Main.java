import java.util.LinkedList;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().permutation("abcdefgh")));
    }
}

class Solution {
    public String[] permutation(String s) {
        LinkedList<String> stringList = new LinkedList<>();
        LinkedList<Character> charList = new LinkedList<>();
        boolean[] flag = new boolean[s.length()];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < flag.length; i++) flag[i] = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag[i]) {
                flag[i] = false;
                charList.add(s.charAt(i));
                dfs(stringList, charList, s, flag, set);
                charList.pollLast();
                flag[i] = true;
            }
        }
        String[] re = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            re[i] = stringList.get(i);
        }
        return re;
    }

    private static void dfs(LinkedList<String> stringList, LinkedList<Character> charList, String s, boolean[] flag, HashSet<String> set) {
        if (charList.size() == s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char x : charList) {
                stringBuilder.append(x);
            }
            String str = stringBuilder.toString();
            if (!set.contains(str)) {
                stringList.add(str);
                set.add(str);
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (flag[i]) {
                    flag[i] = false;
                    charList.add(s.charAt(i));
                    dfs(stringList, charList, s, flag, set);
                    charList.pollLast();
                    flag[i] = true;
                }
            }
        }
    }
}