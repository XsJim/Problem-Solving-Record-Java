public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minPartitions("32"));
        System.out.println(new Solution().minPartitions("82734"));
        System.out.println(new Solution().minPartitions("27346209830709182346"));
    }
}

// 每一位只能是0或1，那么对于给定的数，当某一位存在最大数x时，要满足所有的解数对应位相加为x
// 所以要求最少数目，就取出给定数中最大的数（1~9），最大数为多少，就需要多少个数组合，因为需要最大数个1来组合成为最大数
// 而其他位则可以视情况自由分配
class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for (int i = 0; i < n.length(); i++) {
            int x = n.charAt(i) - '0';
            if (x > ans) ans = x;
        }

        return ans;
    }
}