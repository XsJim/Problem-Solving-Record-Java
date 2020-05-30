public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minDeletionSize(new String[] {"cba", "daf", "ghi"}));
        System.out.println(new Solution().minDeletionSize(new String[] {"a", "b"}));
        System.out.println(new Solution().minDeletionSize(new String[] {"zyx", "wvu", "tsr"}));
    }
}

class Solution {
    public int minDeletionSize(String[] A) {
        char[][] aArrs = new char[A.length][];
        for (int i = 0; i < A.length; i++) aArrs[i] = A[i].toCharArray();
        int sum = 0;
        for (int i = 0; i < aArrs[0].length; i++) {
            char a = aArrs[0][i];
            for (int j = 1; j < aArrs.length; j++) {
                if (aArrs[j][i] < a) {
                    sum++;
                    break;
                }
                a = aArrs[j][i];
            }
        }
        return sum;
    }
}