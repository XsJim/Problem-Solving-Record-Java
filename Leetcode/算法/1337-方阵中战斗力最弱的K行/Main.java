import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().kWeakestRows(new int[][] {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}}, 3)));
    }
}

class Solution {
    class Node {
        int index;
        int x;
        Node(int index, int x) {
            this.index = index;
            this.x = x;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        Node[] nodes = new Node[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int x = 0;
            while (x < mat[i].length) {
                if (mat[i][x] == 0) break;
                x++;
            }
            nodes[i] = new Node(i, x);
        }
        Arrays.sort(nodes, (a, b) -> {
            if (a.x != b.x) return Integer.compare(a.x, b.x);
            return Integer.compare(a.index, b.index);
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = nodes[i].index;
        return ans;
    }
}