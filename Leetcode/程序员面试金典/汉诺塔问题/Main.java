import java.util.List;

class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        talgo(A.size(), A, B, C);
    }

    private static void talgo(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size()-1));
            return;
        }
        talgo(n-1, A, C, B);
        C.add(A.remove(A.size()-1));
        talgo(n-1, B, A, C);
    }
}