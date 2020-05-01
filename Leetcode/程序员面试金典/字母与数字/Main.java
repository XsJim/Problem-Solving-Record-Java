import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findLongestSubarray(new String[] {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"})));
        System.out.println(Arrays.toString(new Solution().findLongestSubarray(new String[] {"A","A"})));
    }
}

class Solution {
    public String[] findLongestSubarray(String[] array) {
        int[] word = new int[array.length+1];
        int[] number = new int[array.length+1];
        boolean[] arrayI = new boolean[array.length];
        talgo(array, arrayI);
        for (int i = 1; i <= arrayI.length; i++) {
            if (arrayI[i-1]) {
                number[i] = number[i-1] + 1;
                word[i] = word[i-1];
            } else {
                number[i] = number[i-1];
                word[i] = word[i-1] + 1;
            }
        }
        int l = -1, r = -1;
        for (int i = 0, j = 1; i <= arrayI.length; i++) {
            while (j <= arrayI.length) {
                if (word[j] - word[i] == number[j] - number[i]) {
                    l = i; r = j - 1;
                }
                j++;
            }
            j = i + r - l + 3;
        }
        if (l == -1 && r == -1) return new String[0];
        String[] ans = new String[r-l+1];
        int i = 0;
        while (l <= r) {
            ans[i++] = ""+array[l++];
        }
        return ans;
    }

    private static void talgo(String[] array, boolean[] arrayI) {
        for (int i = 0; i < array.length; i++) {
            char x = array[i].charAt(0);
            if (x >= '0' && x <= '9') arrayI[i] = true;
        }
    }
}