import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().restoreMatrix(new int[] {3,8}, new int[] {4,7})));
        System.out.println(Arrays.deepToString(new Solution().restoreMatrix(new int[] {5,7,10}, new int[] {8,6,8})));
        System.out.println(Arrays.deepToString(new Solution().restoreMatrix(new int[] {14,9}, new int[] {6,9,8})));
        System.out.println(Arrays.deepToString(new Solution().restoreMatrix(new int[] {1,0}, new int[] {1})));
        System.out.println(Arrays.deepToString(new Solution().restoreMatrix(new int[] {0}, new int[] {0})));
    }
}

// 贪心
// 首先给出填数的策略：从上至下，从左至右，一行一行的填满整个答案矩阵
// 然后说明每个空如何填：对于某个空，有两个条件约束着它，一是当前行的剩余和，二是当前列的剩余和，显然填上去的这个数不能大于它们中的较小值
// 既然不能大于它们中的较小值，就假设填的数等于它们中的较小值
// 接下来粗略说明方法对于每一个空都合适：
// 对于矩阵的首个元素，按照这一填数方法，首先取行列和中较小值填入，然后更新行列和
// 由于填每一个空时，都考虑了该空对应的剩余行和情况，所以，填完第一行时，对应第一行的和和实际和是相符的
// （这里没有说清楚，为何按照这种方式就一定可以使一行的和满足实际情况）
// 第二行同理，又因为每一个空都考虑了对应列和情况，所以，在填完一列时，对应的一列也是满足实际的
// 所以整个矩阵最终是符合给定条件的
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }

        return ans;
    }
}