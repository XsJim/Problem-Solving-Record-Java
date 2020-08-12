public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numEnclaves(new int[][] {{0,0,0,0}, {1,0,1,0}, {0,1,1,0}, {0,0,0,0}}));
        System.out.println(new Solution().numEnclaves(new int[][] {{0,1,1,0}, {0,0,1,0}, {0,0,1,0}, {0,0,0,0}}));
    }
}

class Solution {
    // 给定一个矩阵，统计矩阵中有多少个 1 是不能通过其他 1 和矩阵边界相通的
    // 一开始的想法是：
    // 遍历矩阵，每当遇到 1 ，就开始进行深度优先搜索，将与它相连的 1 全部标记为 -1 ，同时记录被标记的总数
    // 如果搜索过程中，当前位置的 1 在矩阵的边界上，就要做相应的标记，表明当前检查的块（已统计的和将来要统计的）是与边界相连的
    // 这个块中的 1 的数量不应该加到最后的答案中
    // 看题解优化过后：
    // 不需要遍历每一个位置，因为最后求的是不与边界相连的 1 的数量，所以只要将与边界相连的 1 全部标记，然后统计矩阵中未标记的 1 的数量便可
    // 遍历矩阵的四个边，如果遇到 1 ，就开始 dfs ，将与之相连的 1 全部标记
    // 最后在遍历整个矩阵，统计未被标记的 1 的数量
    public int numEnclaves(int[][] A) {
        int ans = 0;
        int[] a = new int[] {-1, 1, 0, 0};
        int[] b = new int[] {0, 0, -1, 1};
        int i = 0, j = 0;
        while (i < A.length) {
            if (A[i][j] == 1) dfs(A, i, j, a, b);
            j = A[i].length-1;
            if (A[i][j] == 1) dfs(A, i, j, a, b);
            i++; j = 0;
        }

        while (j < A[0].length) {
            i = 0;
            if (A[i][j] == 1) dfs(A, i, j, a, b);
            i = A.length - 1;
            if (A[i][j] == 1) dfs(A, i, j, a, b);
            j++;
        }

        while (i >= 0) {
            j = A[i].length - 1;
            while (j >= 0) {
                if (A[i][j] == 1) ans++;
                j--;
            }
            i--;
        }

        return ans;
    }

    private static void dfs(int[][] A, int i, int j, int[] a, int[] b) {
        A[i][j] = -1;

        for (int x = 0; x < a.length; x++) {
            int ii = i + a[x];
            int jj = j + b[x];
            if (ii >= 0 && ii < A.length && jj >= 0 && jj < A[0].length && A[ii][jj] == 1) {
                dfs(A, ii, jj, a, b);
            }
        }
    }
}