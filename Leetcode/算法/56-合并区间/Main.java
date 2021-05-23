import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().merge(new int[][] {{1,3},{2,6},{8,10},{15,18}})));
        System.out.println(Arrays.deepToString(new Solution().merge(new int[][] {{1,4},{4,5}})));
        System.out.println(Arrays.deepToString(new Solution().merge(new int[][] {{1,4}})));
    }
}


// 首先对数组排序，按照第一个元素的大小从小到大排序
// 然后遍历数组，定义一个基础位置 x ，当前位置为 y
// 如果 y 的第一个数字大于 x 的第二个数字，则 y 和 x 区间不重叠，属于两个区间
// 如果 y 的第一个数字小于等于 x 的第二个数字，则 y 和 x 区间重叠，这两个区间合并后的尾部元素为 x, y 中第二个元素的较大元素
// 如果 x 和 y 不重叠，那么 x 也不可能和 y 之后的区间重叠
class Solution {
    public int[][] merge(int[][] intervals) {
        int l = intervals.length;
        boolean[] flag = new boolean[intervals.length];
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int i = 0;
        while (i < intervals.length) {
            int j = i + 1;
            while (j < intervals.length) {
                if (intervals[j][0] <= intervals[i][1]) {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    flag[j] = true;
                    j++;
                    l--;
                } else break;
            }

            i = j;
        }

        int[][] ans = new int[l][2];
        i = 0;
        for (int j = 0; i < intervals.length; i++) {
            if (!flag[i]) {
                ans[j][0] = intervals[i][0];
                ans[j][1] = intervals[i][1];
                j++;
            }
        }

        return ans;
    }
}