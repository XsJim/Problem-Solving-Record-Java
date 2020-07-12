import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[] {8,4,6,2,3})));
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[] {1,2,3,4,5})));
        System.out.println(Arrays.toString(new Solution().finalPrices(new int[] {10,1,1,6})));
    }
}

class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            ans[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    ans[i] -= prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}