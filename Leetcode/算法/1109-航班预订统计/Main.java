import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().corpFlightBookings(new int[][] {{1,2,10}, {2,3,20}, {2,5,25}}, 5)));
    }
}

class Solution {
    // 假设有一辆公交车，每站都可以上下人，题目给定的是多种上下车记录
    // 从每个记录区间的前一个端点上车，后一个端点下车
    // 建立一个数组，首先，数组的每一位表示当前位置的上下车记录
    // 遍历给定的记录数组，将当前记录的上车地点加上上车的人数，表示在这一站多出了多少人
    // 将当前记录的下车地点的下一站（题目中给定的是预定座位的闭区间，当前端点依然会预定座位，所以可以认为人是在下一站下的车）
    // 遍历完所有的记录后，就可以统计每一站的人数了
    // 遍历上下车记录数组，当前车站的人数是当前车站的记录加上前一站的人数，第一站的人数就是第一次遍历之后的数字
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            ans[bookings[i][0]-1] += bookings[i][2];
            if (bookings[i][1] < n) ans[bookings[i][1]] -= bookings[i][2];
        }

        for (int i = 1; i < n; i++) {
            ans[i] += ans[i-1];
        }

        return ans;
    }
}