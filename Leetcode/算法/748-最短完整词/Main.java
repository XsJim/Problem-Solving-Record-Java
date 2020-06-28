public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"}));
        System.out.println(new Solution().shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"}));
    }
}

class Solution {
    private static final int R = 26;

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] lpCount = new int[R];
        for (char x : licensePlate.toCharArray()) {
            if (x >= 'a' && x <= 'z') lpCount[x-'a']++;
            else if (x >= 'A' && x <= 'Z') lpCount[x-'A']++;
        }
        String ans = null; int min = Integer.MAX_VALUE;
        for (String s : words) {
            if (check(lpCount, count(s)) && s.length() < min) {
                ans = s;
                min = s.length();
            }
        }
        return ans;
    }

    private static int[] count(String s) {
        int[] tCount = new int[R];
        for (char x : s.toCharArray()) tCount[x-'a']++;
        return tCount;
    }

    private static boolean check(int[] a, int[] b) {
        for (int i = 0; i < R; i++) {
            if (a[i] > b[i]) return false;
        }
        return true;
    }
}