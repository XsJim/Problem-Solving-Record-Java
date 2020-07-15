public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810"));
        System.out.println(new Solution().getHint("1123", "0111"));
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        int[] a = new int[10];
        int[] b = new int[10];
        char[] sArr = secret.toCharArray();
        char[] gArr = guess.toCharArray();
        int A = 0;
        int B = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == gArr[i]) A++;
            else {
                a[sArr[i]-'0']++;
                b[gArr[i]-'0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (a[i] != 0 && b[i] != 0) B += Math.min(a[i], b[i]); 
        }

        return A+"A"+B+"B";
    }
}