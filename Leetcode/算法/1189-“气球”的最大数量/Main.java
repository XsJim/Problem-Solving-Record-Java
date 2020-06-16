public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxNumberOfBalloons("nlaebolko"));
        System.out.println(new Solution().maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(new Solution().maxNumberOfBalloons("leetcode"));
    }
}

class Solution {
    public int maxNumberOfBalloons(String text) {
        String f = "balloon"; int R = 26; char x = 'a';

        int[] count = new int[R];
        for (char c : text.toCharArray()) {
            count[c-x]++;
        }
        
        int[] flag = new int[R];
        for (char c : f.toCharArray()) {
            flag[c-x]++;
        }

        int min = 100000;
        for (int i = 0; i < R; i++) {
            if (flag[i] != 0) {
                min = Math.min(count[i] / flag[i], min);
            }
        }

        return min;
    }
}