import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().arrayRankTransform(new int[] {40,10,20,30})));
        System.out.println(Arrays.toString(new Solution().arrayRankTransform(new int[] {100,100,100})));
        System.out.println(Arrays.toString(new Solution().arrayRankTransform(new int[] {37,12,28,9,100,56,80,5,12})));
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        class Node {
            int index;
            int x;
            Node(int index, int x) {
                this.index = index;
                this.x = x;
            }
        }

        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) nodes[i] = new Node(i, arr[i]);
        Arrays.sort(nodes, (a, b) -> {
            return Integer.compare(a.x, b.x);
        });

        int[] ans = new int[arr.length];
        if (arr.length > 0) {
            int prev;
            ans[nodes[0].index] = 1;
            prev = nodes[0].x;
            for (int i = 1, j = 1; i < nodes.length; i++) {
                if (nodes[i].x != prev) {
                    prev = nodes[i].x;
                    j++;
                }
                ans[nodes[i].index] = j;
            }
        }
        return ans;
    }
}