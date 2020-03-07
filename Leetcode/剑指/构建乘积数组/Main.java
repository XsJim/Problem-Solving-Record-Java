import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArr(new int[] {2})));
    }
}

class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0 || a.length == 1) return new int[a.length];
        int[] b = new int[a.length+1];
        int[] c = new int[a.length+1];
        b[0] = 1;
        c[a.length] = 1;
        for (int i = 1; i <= a.length; i++) {
            b[i] = b[i-1]*a[i-1];
        }
        for (int i = a.length-1; i >= 0; i--) {
            c[i] = c[i+1]*a[i];
        }
        int[] re = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            re[i] = b[i]*c[i+1];
        }
        return re;
    }
}