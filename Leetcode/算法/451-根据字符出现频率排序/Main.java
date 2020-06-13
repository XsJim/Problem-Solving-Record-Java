import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
        System.out.println(new Solution().frequencySort("cccaaa"));
        System.out.println(new Solution().frequencySort("Aabb"));
    }
}

class Solution {
    private class Node {
        int num;
        int x;

        Node(int num, int x) {
            this.num = num;
            this.x = x;
        }
    }

    public String frequencySort(String s) {
        int R = 256;
        int[] count = new int[R];
        for (char c : s.toCharArray()) count[c]++;
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (first, second) -> {
                if (first.num > second.num) return -1;
                if (first.num == second.num) return 0;
                return 1;
            }
        );
        for (int i = 0; i < R; i++) {
            if (count[i] != 0) {
                pq.add(new Node(count[i], i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            for (Node i = pq.poll(); i.num > 0; i.num--) {
                sb.append((char)i.x);
            }
        }
        return sb.toString();
    }
}