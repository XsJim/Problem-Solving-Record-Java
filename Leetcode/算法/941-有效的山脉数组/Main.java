public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().validMountainArray(new int[] {2,1}));
        System.out.println(new Solution().validMountainArray(new int[] {3,5,5}));
        System.out.println(new Solution().validMountainArray(new int[] {0,3,2,1}));
    }
}

// 遍历检测即可
// 注意几种特殊情况：
// 数组长度小于3
// 从第二位开始便开始递减
// 直到最后一位都是递增
class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) return false;
            if (flag) {
                if (arr[i] < arr[i-1]) {
                    if (i == 1) return false;
                    flag = false;
                }
            } else {
                if (arr[i] > arr[i-1]) return false;
            }
        }

        return !flag;
    }
}