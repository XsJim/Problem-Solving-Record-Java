public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumProduct(new int[] {1,2,3}));
        System.out.println(new Solution().maximumProduct(new int[] {1,2,3,4}));
    }
}

class Solution {
    public int maximumProduct(int[] nums) {
        int[] map = new int[2001];
        for (int i = 0; i < nums.length; i++) map[nums[i]+1000]++;
        int ans1 = 1, ans2 = 1;
        bre: for (int i = 2000, j = 0; i >= 0; i--) {
            int temp = map[i];
            while (temp > 0) {
                ans1 *= (i - 1000);
                if (++j == 3) break bre;
                if (j == 1) ans2 *= (i - 1000);
                temp--;
            }
        }
        br: for (int i = 0, j = 0; i <= 2000; i++) {
            while (map[i] > 0) {
                ans2 *= (i - 1000);
                if (++j == 2) break br;
                map[i]--;
            }
        }
        return Math.max(ans1, ans2);
    }
}