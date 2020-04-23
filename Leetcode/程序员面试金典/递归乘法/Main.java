public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply(1, 10));
        System.out.println(new Solution().multiply(3, 4));
    }
}

class Solution {
    public int multiply(int A, int B) {
        if (A > B) return talgo(B, A);
        else return talgo(A, B);
    }

    private static int talgo(int A, int B) {
        if (A == 0) return 0;
        return B + talgo(A-1, B);
    }
}