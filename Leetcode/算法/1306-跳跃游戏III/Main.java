public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canReach(new int[] {4,2,3,0,3,1,2}, 5));
        System.out.println(new Solution().canReach(new int[] {4,2,3,0,3,1,2}, 0));
        System.out.println(new Solution().canReach(new int[] {3,0,2,1,2}, 2));
    }
}

class Solution {
    // 由起始位置出发，在接下来每一个可以到达且元素不为 0 的位置，都可以跳向两个地方
    // i+arr[i] 和 i-arr[i] ，如果它们依然满足条件且对应元素不为 0 ，则可以继续跳
    // 每个位置对应的分支都为两个，且其他判断条件都相同，所以程序使用递归实现
    // 递归变量中，有一个表示当前到达的位置的下标
    // 首先递归程序要判断这个值是否在数组下标范围内
    // 如果在，则要判断对应元素是否为 0 ，若为 0 ，则说明游戏可以成功，可以结束继续向下递归
    // 若不为 0 ，则要首先判断当前位置是否已经到达过，这时需要一个标记过已访问位置的标记数组
    // 如果这个位置已访问过，则无需向下继续递归，因为当前位置已经判断过
    // 如果这个位置还未访问，首先将其标记
    // 再继续递归访问从此位置可以跳跃到达的两个位置
    public boolean canReach(int[] arr, int start) {
        return jump(arr, start, new boolean[arr.length]);
    }

    private static boolean jump(int[] arr, int i, boolean[] flag) {
        if (i < 0 || i >= arr.length) return false;
        if (arr[i] == 0) return true;
        if (flag[i]) return false;
        flag[i] = true;
        return jump(arr, i-arr[i], flag) || jump(arr, i+arr[i], flag);
    }
}