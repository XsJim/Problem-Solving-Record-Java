public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedNTimes(new int[] {1,2,3,3}));
        System.out.println(new Solution().repeatedNTimes(new int[] {2,1,2,5,3,2}));
        System.out.println(new Solution().repeatedNTimes(new int[] {5,1,5,2,5,3,5,4}));
    }
}

class Solution {
    public int repeatedNTimes(int[] A) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < A.length - i; j++) {
                if (A[j] == A[j+i]) return A[j];
            }
        }
        return -1;
    }
}