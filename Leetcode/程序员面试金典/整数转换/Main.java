public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().convertInteger(29, 15));
        System.out.println(new Solution().convertInteger(1, -1));
        System.out.println(new Solution().convertInteger(1, 2));
        System.out.println(new Solution().convertInteger(826966453, -729934991));
    }
}

class Solution {
    public int convertInteger(int A, int B) {
        int C = A ^ B;
        int count = 0;
        while (C != 0) {
            C &= (C - 1);
            count++;
        }
        return count;
    }
}