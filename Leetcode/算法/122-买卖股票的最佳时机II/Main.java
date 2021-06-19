public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(new Solution().maxProfit(new int[] {1,2,3,4,5}));
        System.out.println(new Solution().maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(new Solution().maxProfit(new int[] {3,3,5,0,0,3,1,4}));
    }
}

// 定义一个区间，区间名为坡：该区间为一个不递减的连续数据段
// 在该题中，只需要找出所有为坡的区间，将每个坡的终点和起点的差相加，就可得到答案
class Solution {
    public int maxProfit(int[] prices) {
        int first = 0, second = 1;
        int ans = 0;
        while (second < prices.length) {
            if (prices[second] < prices[second-1]) {
                ans += prices[second-1] - prices[first];
                first = second;
            }
            second++;
        }

        if (first != prices.length - 1) {
            ans += prices[prices.length - 1] - prices[first];
        } 

        return ans;
    }
}