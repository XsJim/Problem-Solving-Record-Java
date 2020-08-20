public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkIfExist(new int[] {10,2,5,3}));
        System.out.println(new Solution().checkIfExist(new int[] {7,1,14,11}));
        System.out.println(new Solution().checkIfExist(new int[] {3,1,7,11}));
    }
}

class Solution {
    // 要知道的是，在给定数组中，是否有一个整数，它的倍数或它的二分之一也存在于数组中
    // 给定的出现整数范围是 -1000 ~ 1000
    // 直接的思路是：
    // 设立标记数组，长度为 2001 （从 -1000 到 1000 有 2001 个数，每个数字加上 1000 即可在数组中找到自己的位置）
    // 遍历一次数组，将出现的数字做标记
    // 第二次遍历数组时，确定当前数字的二倍或二分之一是否存在于数组中
    // 存在的问题：
    // 首先是 0 的问题，0 的二倍或二分之一都还是 0 ，如果标记数组只表示数字是否出现而不记录出现次数，那么在遇到 0 的时候就会出现错误
    // 此时如果 0 出现过，那么程序会直接返回答案，但是这时的 0 可能只出现过一次，那就不满足 i != j 的条件
    // 所以标记数组应该记录数字出现的次数，在第一次遍历完毕后，就先判断 0 出现的次数，如果大于 1 ，那么直接返回答案
    // 否则，将 0 的个数清空，以便在接下来的遍历中不会返回错误的答案
    // 其次，程序的标记是依靠原数字加 1000 来找位置进行的，第二次遍历时，会将当前数字乘以 2
    // 可能会出现这种情况：乘以 2 后，得到的数字超出 -1000 ~ 1000 ，那么这时再加上 1000 ，就会超出标记数组的范围
    public boolean checkIfExist(int[] arr) {
        int[] map = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]+1000]++;
        }
        if (map[1000] > 1) return true;
        map[1000] = 0;

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] * 2 + 1000;
            if (x >= 0 && x < map.length && map[x] > 0) return true;
            if ((arr[i] & 1) == 0) {
                x = arr[i] / 2;
                if (map[x+1000] > 0) return true;
            }
        }

        return false;
    }
}