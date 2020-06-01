public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countCharacters(new String[] {"cat","bt","hat","tree"}, "atach"));
        System.out.println(new Solution().countCharacters(new String[] {"hello","world","leetcode"}, "welldonehoneyr"));
    }
}

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] chars_count = new int[26];
        for (char x : chars.toCharArray()) chars_count[x-'a']++;
        int sum = 0;
        for (String s : words) {
            int[] s_count = new int[26];
            boolean flag = false;
            for (char x : s.toCharArray()) {
                int index = x-'a';
                s_count[index]++;
                if (s_count[index] > chars_count[index]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) sum += s.length();
        }
        return sum;
    }
}