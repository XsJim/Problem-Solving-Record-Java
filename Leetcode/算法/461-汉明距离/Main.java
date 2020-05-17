public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4));
    }
}

class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ans = 0;
        while (z != 0) {
            z &= (z - 1);
            ans++;
        }
        return ans;
    }
}