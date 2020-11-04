public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numSpecial(new int[][] {{1,0,0},{0,0,1},{1,0,0}}));
        System.out.println(new Solution().numSpecial(new int[][] {{1,0,0},{0,1,0},{0,0,1}}));
        System.out.println(new Solution().numSpecial(new int[][] {{0,0,0,1},{1,0,0,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println(new Solution().numSpecial(new int[][] {{0,0,0,0,0},{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}}));
    }
}

// 建立两个数组，统计每行，每列 1 的个数
// 然后，再次遍历二维数组，如果元素是 1
// 就判断计数数组中，这一行，这一列 1 的个数是否是 1 ，如果是 1 ，说明这是一个特殊位置
class Solution {
    public int numSpecial(int[][] mat) {
        int[] flagx = new int[mat.length];
        int[] flagy = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                flagx[i] += mat[i][j];
                flagy[j] += mat[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && flagx[i] == 1 && flagy[j] == 1) ans++;
            }
        }

        return ans;
    }
}