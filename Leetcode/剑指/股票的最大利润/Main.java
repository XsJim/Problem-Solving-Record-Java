public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {3,6}));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int[] tmin = new int[prices.length-1];
        int[] tmax = new int[prices.length-1];
        tmin[0] = prices[0];
        tmax[prices.length-2] = prices[prices.length-1];
        for (int i = 1; i < prices.length-1; i++) {
            tmin[i] = prices[i] < tmin[i-1] ? prices[i] : tmin[i-1];
        }
        for (int i = prices.length-3; i >= 0; i--) {
            tmax[i] = prices[i+1] < tmax[i+1] ? tmax[i+1] : prices[i+1];
        }
        int re = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int sum = tmax[i] - tmin[i];
            if (sum  > re) re = sum;
        }
        return re;
    }
}