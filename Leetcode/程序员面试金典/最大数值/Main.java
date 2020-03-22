public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maximum(1, 2));
        System.out.println(new Solution().maximum(-10, 2));
    }
}

class Solution {
    public int maximum(int a, int b) {
        long add = (long)a + (long)b;
        long diff = (long)a - (long)b;
        long diffABS = (diff ^ (diff >> 63)) - (diff >> 63);
        return (int)((add + diffABS) / 2);
    }
}