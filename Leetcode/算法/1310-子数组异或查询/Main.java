import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().xorQueries(new int[] {1,3,4,8}, new int[][] {{0,1}, {1,2}, {0,3}, {3,3}})));
    }
}

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length+1];
        for (int i = 1; i <= arr.length; i++) xor[i] = xor[i-1] ^ arr[i-1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = xor[queries[i][0]] ^ xor[queries[i][1]+1];
        }
        return ans;
    }
}