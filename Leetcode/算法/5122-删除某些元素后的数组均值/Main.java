public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().trimMean(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}));
        System.out.println(new Solution().trimMean(new int[] {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0}));
        System.out.println(new Solution().trimMean(new int[] {6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4}));
        System.out.println(new Solution().trimMean(new int[] {9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3}));
        System.out.println(new Solution().trimMean(new int[] {4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1}));
    }
}

// 遍历数组，桶排序记录每个数出现次数，同时记录和
// 前后遍历桶数组，删除要求的数据量
// 返回剩余数的平均值
class Solution {
    public double trimMean(int[] arr) {
        int[] count = new int[100005];
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            count[arr[i]]++;
        }

        int x = arr.length / 20;
        int cc = 0;
        int j = 0;
        while (cc < x) {
            while (count[j] == 0) j++;
            count[j]--;
            cc++;
            sum -= j;
        }

        cc = 0;
        j = 100004;
        while (cc < x) {
            while (count[j] == 0) j--;
            count[j]--;
            cc++;
            sum -= j;
        }

        return sum / (arr.length - arr.length / 10);
    }
}