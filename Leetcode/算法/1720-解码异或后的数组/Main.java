import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decode(new int[] {1,2,3}, 1)));
        System.out.println(Arrays.toString(new Solution().decode(new int[] {6,2,7,3}, 4)));
    }
}

class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length+1];
        ans[0] = first;

        for (int i = 1, j = 0; i < ans.length; i++, j++) {
            ans[i] = ans[j] ^ encoded[j];
        }

        return ans;
    }
}