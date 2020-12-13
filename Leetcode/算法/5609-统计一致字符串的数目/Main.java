public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countConsistentStrings("ab", new String[] {"ad","bd","aaab","baa","badab"}));
        System.out.println(new Solution().countConsistentStrings("abc", new String[] {"a","b","c","ab","ac","bc","abc"}));
        System.out.println(new Solution().countConsistentStrings("cad", new String[] {"cc","acd","b","ba","bac","bad","ac","d"}));
    }
}

// 首先确定对比字符串中有哪些字符
// 然后遍历检查数组中的每一个字符串，如果字符串中出现了没有在对比字符串中出现的字符，就说明这个字符串不是一致的
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] flag = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            flag[allowed.charAt(i)-'a'] = 1;
        }

        int sum = words.length;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (flag[words[i].charAt(j)-'a'] == 0) {
                    sum--;
                    break;
                }
            }
        }

        return sum;
    }
}