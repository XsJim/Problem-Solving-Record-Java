public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findCircleNum(new int[][] {{1,1,0}, {1,1,0}, {0,0,1}}));
        System.out.println(new Solution().findCircleNum(new int[][] {{1,1,0}, {1,1,1}, {0,1,1}}));
        System.out.println(new Solution().findCircleNum(new int[][] {{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}}));
    }
}

class Solution {

    // 考查：并查集
    // 首先遍历给定的数组，只需要遍历左上至右下对角线上方的区域，因为上下两部分是对称的
    // 如果元素为 1 ，就合并 i 和 j 的朋友圈
    // 初始朋友圈的个数为人数 n ，每次真实的合并一次（将两个不同的朋友圈合并为一个），就将 n 减一，最终的 n 就是朋友圈的个数
    // 并查集部分分为两块
    // 一、找根元素，在此过程中，进行路径优化，将该朋友圈下的所有人的根都设置为同一值
    // 二、合并个两朋友圈，首先查找两个朋友圈的根元素（同时优化了路径）。如果两根元素不同，则将其中一根的根元素（自己）改为另一根元素，这时发生了合并，所以将朋友圈总数减一
    // 三、由于合并后没有再次优化路径，最终的并查集并不一定与得到的朋友圈总数相匹配

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] friend = new int[n];

        int[] ans = new int[] {n};

        for (int i = 0; i < n; i++) friend[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    merge(i, j, friend, ans);
                }
            }
        }
        
        return ans[0];
    }

    private static void merge(int i, int j, int[] friend, int[] ans) {
        int iRoot = findRoot(friend, i);
        int jRoot = findRoot(friend, j);
        if (iRoot != jRoot) {
            friend[jRoot] = iRoot;
            ans[0]--;
        }
    }

    private static int findRoot(int[] friend, int x) {
        if (friend[x] == x) return x;
        friend[x] = findRoot(friend, friend[x]);
        return friend[x];
    }
}