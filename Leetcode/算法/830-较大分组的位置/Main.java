import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().largeGroupPositions("abbxxxxzzy"));
        System.out.println(new Solution().largeGroupPositions("abc"));
        System.out.println(new Solution().largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(new Solution().largeGroupPositions("aba"));
    }
}

// 遍历字符串，取出连续相同且长度大于等于三的子字符串的起始和结束位置下标
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        char prev = s.charAt(0);
        int count = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == prev) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i-1);
                    ans.add(list);
                }
                prev = cur;
                count = 1;
                start = i;
            }
        }

        if (count >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(s.length()-1);
            ans.add(list);
        }

        return ans;
    }
}