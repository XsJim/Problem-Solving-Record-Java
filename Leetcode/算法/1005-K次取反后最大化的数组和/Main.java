import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().largestSumAfterKNegations(new int[] {4,2,3}, 1));
        System.out.println(new Solution().largestSumAfterKNegations(new int[] {3,-1,0,2}, 3));
        System.out.println(new Solution().largestSumAfterKNegations(new int[] {2,-3,-1,5,-4}, 2));
    }
}

// 每次选取所有数中的最小值将其取反，可得到最优解
// 如果所有数是正数，那么从最小值开始取反，可尽可能的使总和最大
// 如果所有数都是负数，选取最小值，同样也会使总和最大
// 如果数有正有负，那么选取最小值，同样是将负数取反，或者将最小正数取反，同样会使总和最大
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) pq.add(A[i]);
        while (K-- > 0) {
            int x = pq.poll();
            pq.add(-x);
        }

        int[] sum = new int[] {0};
        pq.forEach(a->{sum[0]+=a;});

        return sum[0];
    }
}