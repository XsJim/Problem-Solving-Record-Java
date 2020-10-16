public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[] {2,4,1,2,7,8}));
        System.out.println(new Solution().maxCoins(new int[] {2,4,5}));
        System.out.println(new Solution().maxCoins(new int[] {9,8,7,6,5,1,2,3,4}));
    }
}

// 将数组排序
// 每次 Alice 拿当前最大
// 我拿当前第二大
// Bob 拿最小
class Solution {
    public int maxCoins(int[] piles) {
        int[] map = new int[10004];
        for (int i = 0; i < piles.length; i++) {
            map[piles[i]]++;
        }

        int ans = 0;
        int count = 0;
        int i = 10000;
        boolean flag = true;
        while (count < (piles.length / 3)) {
            if (flag && map[i] > 0) {
                map[i]--;
                flag = false;
            }
            if (!flag && map[i] > 0) {
                ans += i;
                map[i]--;
                count++;
                flag = true;
            }
            if (map[i] == 0) i--;
        }

        return ans;
    }
}