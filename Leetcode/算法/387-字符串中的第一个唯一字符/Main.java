public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }
}

class Solution {
    // 首先遍历字符串，统计每个字符的出现次数，一并记录首次出现的下标
    // 然后遍历记录数组，如果当前字符的出现次数为 1 并且它的下标小于当前符合条件的最小下标，就将当前最小置换为它
    public int firstUniqChar(String s) {
        int R = 26;
        int[] count = new int[R];
        int[] first_index = new int[R];
        for (int i = 0; i < R; i++) first_index[i] = -1;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            count[x]++;
            if (first_index[x] == -1) first_index[x] = i;
        }

        int ans = -1;

        for (int i = 0; i < R; i++) {
            if (count[i] == 1) {
                if (first_index[i] < ans || ans == -1) ans = first_index[i];
            }
        }

        return ans;
    }
}