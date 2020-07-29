import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxCandies(new int[] {1,0,1,0},  new int[] {7,5,4,100}, new int[][] {{}, {}, {1}, {}}, new int[][] {{1,2}, {}, {}, {}}, new int[] {0}));
    }
}

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        class Node {
            int index;
            int[] haveKey;

            Node(int index, int[] haveKey) {
                this.index = index;
                this.haveKey = haveKey;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.haveKey[b.index], a.haveKey[a.index]);
        });
        int num = status.length;
        int[] haveKey = new int[num];
        for (int i = 0; i < num; i++) haveKey[i] = status[i];

        for (int i = 0; i < initialBoxes.length; i++) pq.add(new Node(initialBoxes[i], haveKey));

        int ans = 0;
        while (pq.size() > 0 && haveKey[pq.peek().index] == 1) {
            int index = pq.poll().index;
            ans += candies[index];
            for (int i : keys[index]) haveKey[i] = 1;
            for (int i : containedBoxes[index]) pq.add(new Node(i, haveKey));
        }

        return ans;
    }
}