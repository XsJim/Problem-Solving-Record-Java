public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxVowels("abciiidef", 3));
        System.out.println(new Solution().maxVowels("aeiou", 2));
        System.out.println(new Solution().maxVowels("leetcode", 3));
        System.out.println(new Solution().maxVowels("rhythms", 4));
        System.out.println(new Solution().maxVowels("tryhard", 4));
    }
}

class Solution {
    // 计算字符串中，定长字串中拥有元音的最大数目
    // 遍历字符串，将每个字符作为子串的起始字母，然后计算该字串中的元音数目，得到最大值
    // 在计算字串的元音数目时，同一个字符可能被多次判断
    // 为了加快这一步骤，首先创建一个长度为字符串长度加 1 的计数数组，然后从后至前遍历字符串
    // 计数数组中对应字符位置的元素为包含该字符以及它之后所有字符中，元音字母的数量
    // 得到这个计数数组后，计算一个字串包含的元音数目时，就可以通过计算 count[i] - count[i+k] 来计算
    // 其中， i 是当前字符的下标，i+k 是当前判断的字串的后一个字符位置
    // 它们相减，就得到了该字串的元音数目
    public int maxVowels(String s, int k) {
        int[] count = new int[s.length()+1];
        int[] map = new int[26];
        map['a'-'a'] = 1;
        map['e'-'a'] = 1;
        map['i'-'a'] = 1;
        map['o'-'a'] = 1;
        map['u'-'a'] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            count[i] = count[i+1] + map[s.charAt(i)-'a'];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= s.length() - k; i++) {
            int x = count[i] - count[i+k];
            if (x > max) max = x;
        }

        return max;
    }
}