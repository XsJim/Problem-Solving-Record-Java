public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findCenter(new int[][] {{1,2},{2,3},{4,2}}));
        System.out.println(new Solution().findCenter(new int[][] {{1,2},{5,1},{1,3},{1,4}}));
    }
}

class Solution {
    public int findCenter(int[][] edges) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (edges[0][i] == edges[1][j]) return edges[0][i];
            }
        }

        return -1;
    }
}