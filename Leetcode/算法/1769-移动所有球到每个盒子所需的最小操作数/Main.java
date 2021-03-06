import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().minOperations("110")));
        System.out.println(Arrays.toString(new Solution().minOperations("001011")));
    }
}

class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] rightBall = new int[len+1];
        int[] ans = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (boxes.charAt(i) == '1') {
                rightBall[i] = rightBall[i+1] + 1;
                ans[0] += i;
            }
            else rightBall[i] = rightBall[i+1];
        }
        
        for (int i = 1, leftBall = boxes.charAt(0) - '0'; i < len; i++) {
            ans[i] = ans[i-1] + leftBall - rightBall[i];
            leftBall += (boxes.charAt(i) - '0');
        }

        return ans;
    }
}