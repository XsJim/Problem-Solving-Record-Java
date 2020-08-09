import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}

class Solution {
    // 从 2~9 的每个数字都代表着几个字母，给定一个由 2~9 组成的字符串，将这个数字字符串对应的所有字母字符串输出
    // 首先，每个数字都对应着几个不同的字母，这是事先约定好的
    // 为了之后读取数据方便，将它们放入一个二维数组中，行坐标对应着相应的数字，每行都是该数字对应的那些字母
    // 为了生成所有可能的结果，需要从第一个位置开始，遍历每一种可能，使用递归会更加方便
    // 当递归的位置到达最后一个数字之后的位置，就表示这一轮的结果生成了，将这一种可能加入到答案中

    public List<String> letterCombinations(String digits) {
        char[][] map = new char[][] {
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'},
        };
        List<String> ans = new ArrayList<>();
        if (digits.length() != 0) talgo(digits, 0, map, ans, new char[digits.length()]);
        return ans;
    }

    private static void talgo(String digits, int i, char[][] map, List<String> ans, char[] current) {
        if (i == digits.length()) {
            ans.add(new String(current));
            return;
        }

        for (char x : map[digits.charAt(i)-'0']) {
            current[i] = x;
            talgo(digits, i+1, map, ans, current);
        }
    }
}