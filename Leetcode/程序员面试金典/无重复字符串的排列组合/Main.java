import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().permutation("qwe")));
        System.out.println(Arrays.toString(new Solution().permutation("ab")));
    }
}

class Solution {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] flag = new boolean[chars.length];
        int len = 1;
        for (int i = 2; i <= chars.length; i++) len *= i;
        String[] ans = new String[len];
        int[] index = new int[1];
        for (int i = 0; i < chars.length; i++) {
            flag[i] = true;
            talgo(flag, chars, ans, index, chars[i]+"");
            flag[i] = false;
        }
        return ans;
    }

    private static void talgo(boolean[] flag, char[] chars, String[] ans, int[] index, String str) {
        if (chars.length == str.length()) {
            ans[index[0]++] = str;
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                talgo(flag, chars, ans, index, str+chars[i]);
                flag[i] = false;
            }
        }
    }
}