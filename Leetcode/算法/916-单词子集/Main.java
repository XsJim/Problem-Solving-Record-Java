import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] A = new String[] {"amazon","apple","facebook","google","leetcode"};
        System.out.println(new Solution().wordSubsets(A, new String[] {"e","o"}));
        System.out.println(new Solution().wordSubsets(A, new String[] {"l","e"}));
        System.out.println(new Solution().wordSubsets(A, new String[] {"e","oo"}));
        System.out.println(new Solution().wordSubsets(A, new String[] {"lo","eo"}));
        System.out.println(new Solution().wordSubsets(A, new String[] {"ec","oc","ceo"}));
    }
}

class Solution {
    // 理解题意后
    // 该题要求 A 满足条件：单词中包含 B 中每一个单词的所有字符
    // 既然要满足所有 B 中字符串，那么满足 B 中某个字符的最大出现次数，便也满足了 B 中的其他单词
    // 首先求出 B 字符串数组中，每个字母在所有单词中的最大出现次数
    // A 中的单词，要求所有对应字符的出现次数大于等于这个值，才能算作对 B 通用
    private static int R = 26;
    public List<String> wordSubsets(String[] A, String[] B) {
        
        int[] count = new int[R];

        for (String s : B) {
            int[] current = getCount(s);
            for (int i = 0; i < R; i++) {
                if (current[i] > count[i]) {
                    count[i] = current[i];
                }
            }
        }

        List<String> ans = new ArrayList<>();

        for (String s : A) {
            int[] current = getCount(s);
            boolean flag = true;
            
            for (int i = 0; i < R; i++) {
                if (count[i] > current[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) ans.add(s);
        }

        return ans;
    }

    private static int[] getCount(String s) {
        int[] count = new int[R];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        return count;
    }
}