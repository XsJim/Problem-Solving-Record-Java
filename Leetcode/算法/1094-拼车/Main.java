import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().carPooling(new int[][] {{2,1,5},{3,3,7}}, 4));
        System.out.println(new Solution().carPooling(new int[][] {{2,1,5},{3,3,7}}, 5));
        System.out.println(new Solution().carPooling(new int[][] {{2,1,5},{3,5,7}}, 3));
        System.out.println(new Solution().carPooling(new int[][] {{3,2,7},{3,7,9},{8,3,9}}, 11));
    }
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        class Node {
            int x;
            int num;
            Node(int x, int num) {
                this.x = x;
                this.num = num;
            }
        }

        Arrays.sort(trips, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        int nNum = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.x, b.x);
        });

        for (int i = 0; i < trips.length; i++) {
            while (pq.size() != 0 && pq.peek().x <= trips[i][1]) {
                nNum -= pq.poll().num;
            }
            nNum += trips[i][0];
            if (nNum > capacity) return false;
            pq.add(new Node(trips[i][2], trips[i][0]));
        }

        return true;
    }
}