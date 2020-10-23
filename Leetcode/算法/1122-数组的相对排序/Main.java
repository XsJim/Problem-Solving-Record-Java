import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[] {2,1,4,3,9,6})));
    }
}

// 首先记录每个元素在数组 1 中出现次数
// 然后遍历数组 2 ，按顺序将数子按照第一步统计好的数字放入答案数组
// 然后遍历计数数组，当个数不为 0 且不在数组 2 中标记时，将其按照个数放入答案数组
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] flag = new int[1005];
        int[] count = new int[1005];
        for (int i = 0; i < arr2.length; i++) flag[arr2[i]] = 1;
        for (int i = 0; i < arr1.length; i++) count[arr1[i]]++;
        int[] ans = new int[arr1.length];
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int z = 0; z < count[arr2[i]]; z++) {
                ans[j++] = arr2[i];
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (flag[i] == 0 && count[i] > 0) {
                for (int z = 0; z < count[i]; z++) {
                    ans[j++] = i;
                }
            }
        }

        return ans;
    }
}