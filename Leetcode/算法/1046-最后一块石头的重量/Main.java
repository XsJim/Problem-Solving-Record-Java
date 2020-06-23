import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeight(new int[] {2,7,4,1,8,1}));
        System.out.println(new Solution().lastStoneWeight(new int[] {2,2}));
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (a < b) return 1;
            if (a > b) return -1;
            return 0;
        });
        for (int i : stones) pq.add(i);
        while (pq.size() > 1) {
            int cur = Math.abs(pq.poll() - pq.poll());
            if (cur != 0) pq.add(cur);
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}