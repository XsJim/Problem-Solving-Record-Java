public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numSplits("aacaba"));
        System.out.println(new Solution().numSplits("abcd"));
        System.out.println(new Solution().numSplits("aaaaa"));
        System.out.println(new Solution().numSplits("acbadbaada"));
    }
}

// 建立两个散列数组，保存每个字符的出现数量
// 左散列记录左边字符串中每个字符的数量，右散列记录右边字符串中每个字符的数量
// 再创建两个用来记录两边字符串中不同字符数量的变量
// 从第二个字符开始，从左向右依次遍历每个字符，直到倒数第二个字符
// 如果当前字符在左边字符串已经存在，则标记左边字符串中不同字符数的变量不需更改，否则增 1
// 如果当前字符在右边字符串中只剩下这即将去掉的一个，则标记右边字符串中不同字符数的变量减 1，否则不变
// 每次检测之后，对比两个变量的值是否相等，如果相等，则好分割数目增 1
class Solution {
    public int numSplits(String s) {
        int ans = 0;
        int left = 0, right = 0;
        int[] map_left = new int[26];
        int[] map_right = new int[26];
        if (s.length() > 1) {
            left = 1;
            map_left[s.charAt(0)-'a']++;
        }
        for (int i = 1; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (map_right[x] == 0) right++;
            map_right[x]++;
        }
        if (left == right) ans++;
        for (int i = 1; i < s.length() - 1; i++) {
            int x = s.charAt(i) - 'a';
            if (map_left[x] == 0) {
                map_left[x]++;
                left++;
            }
            map_right[x]--;
            if (map_right[x] == 0) {
                right--;
            }
            if (left == right) ans++;
        }

        return ans;
    }
}