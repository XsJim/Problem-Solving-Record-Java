import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().masterMind("RGBY", "GGRR")));
    }
}

class Solution {
    public int[] masterMind(String solution, String guess) {
        int[] ans = new int[2];
        char[] solChars = solution.toCharArray();
        char[] gueChars = guess.toCharArray();
        for (int i = 0; i < 4; i++) {
            if (solChars[i] == gueChars[i]) {
                solChars[i] = '.'; gueChars[i] = '_';
                ans[0]++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j && solChars[i] == gueChars[j]) {
                    ans[1]++;
                    gueChars[j] = '_';
                    break;
                }
            }
        }
        return ans;
    }
}