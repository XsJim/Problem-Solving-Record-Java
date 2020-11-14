public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(new Solution().maxProfit(new int[] {7,6,4,3,1}));
    }
}

// 在数组中，所有数按原数组顺序两两组成子数组，后一个数减去前一个数，求这个值最大为多少（最小为 0 ）
// 对于每个数，只需要知道在它之后的最大数值，便可知道由它组成的子数组中的最大差值
// 所以倒序遍历数组，首先确定包括当前元素的最大值，然后用这个最大值减去当前元素，即可得到当前元素的最大差值
// 返回遍历之后的最大最大差值
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int max = -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) max = prices[i];
            ans = Math.max(max - prices[i], ans);
        }

        return ans;
    }
}