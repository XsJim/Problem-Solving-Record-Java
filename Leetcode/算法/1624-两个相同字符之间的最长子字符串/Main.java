public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("aa"));
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("abca"));
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("cabbac"));
    }
}

// 首先找到每个字符的首次出现下标和最后出现下标
// 然后在每个字符首尾距离中找到最大值，就是所求答案
// 如果每个字符都只出现过一次，则这个值不存在
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first_index = new int[26];
        int[] max_index = new int[26];

        for (int i = 0; i < 26; i++) {
            first_index[i] = -1;
            max_index[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (first_index[x] == -1) first_index[x] = i;
            else  max_index[x] = i;
        }
        int ans = -1;
        for (int i = 0; i < 26; i++) {
            if (first_index[i] != -1 && max_index[i] != -1) {
                ans = Math.max(max_index[i] - first_index[i] - 1, ans);
            }
        }

        return ans;
    }
}