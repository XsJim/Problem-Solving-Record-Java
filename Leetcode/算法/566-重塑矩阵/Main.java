import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().matrixReshape(new int[][] {{1,2},{3,4}}, 1, 4)));
        System.out.println(Arrays.deepToString(new Solution().matrixReshape(new int[][] {{1,2},{3,4}}, 2, 4)));
    }
}

// 首先判断给定的行列数是否满足要求，即两个矩阵可容纳的元素数是否相同，如果不同，返回原数组
// 否则，构造新的数组，遍历原数组，逐个将元素添加到新数组，然后返回这个新数组
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) return nums;
        int[][] ans = new int[r][c];
        int x = 0, y = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (y == c) {
                    x++;
                    y = 0;
                }
                ans[x][y] = nums[i][j];
                y++;
            }
        }

        return ans;
    }
}