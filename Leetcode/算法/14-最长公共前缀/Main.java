public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}

// 首先遍历字符串数组，得到最短的字符串长度 X
// 答案字符串的长度最长为 X
// 假设其最短长度为 0
// 使用二分法，枚举它的可能长度
// 然后使用这个可能长度来遍历字符串数组，检查它们的为这个长度的前缀是否相同
// 如果都相同，就将最短长度更改为当前可能长度 + 1 ，下次循环检查时，从已经检查过的字符的下一位开始，也就是下次起始下标为当前可能长度
// 否则，缩短最大长度为当前可能长度值 - 1
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLen = 300;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) minLen = strs[i].length();
        }

        if (minLen == 0) return "";

        int left = 0;
        int len = 0;
        int i = 0;
        while (left <= minLen) {
            int mid = (left + minLen) / 2;
            boolean flag = true;
            w: for (; i < strs.length; i++) {
                for (int j = len; j < mid; j++) {
                    if (strs[0].charAt(j) != strs[i].charAt(j)) {
                        flag = false;
                        break w;
                    }
                }
            }

            if (flag) {
                left = mid + 1;
                len = mid;
                i = 0;
            } else {
                minLen = mid - 1;
            }
        }
        return strs[0].substring(0, len);
    }
}