public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("abaccdeff"));
    }
}

class Solution {
    public char firstUniqChar(String s) {
        char re = ' ';
        int[] counter = new int[128];
        for (int i = 0; i < 128; i++) counter[i] = 0;
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i)] == 1) {
                re = s.charAt(i);
                break;
            }
        }
        return re;
    }
}