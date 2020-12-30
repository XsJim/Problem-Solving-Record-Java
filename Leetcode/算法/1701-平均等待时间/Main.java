public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().averageWaitingTime(new int[][] {{1,2},{2,5},{4,3}}));
        System.out.println(new Solution().averageWaitingTime(new int[][] {{5,2},{5,4},{10,3},{20,1}}));
    }
}

// 设定厨师当前时间
// 便利数组
// 如果厨师当前时间小于等于顾客到来时间，则说明这个顾客不需要等待，直接给总等待时间加上做菜时间即可
// 否则，则说明这个顾客已经等待了一段时间，这个时间是厨师当前时间减去顾客到来时间，这种情况需要先加上这个等待时间，然后再加上做菜时间
// 每做完一个人的菜，需要改变厨师当前时间
// 如果厨师遇到这个顾客就开始做菜，那么只要加上做菜时间即可
// 否则，需要加上厨师等待顾客的时间
// 返回总等待时间除以总人数即可
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum = 0;
        int curTime = 0;
        for (int i = 0; i < customers.length; i++) {
            int wait = curTime - customers[i][0];
            sum += Math.max(0, wait);

            sum += customers[i][1];

            curTime += (Math.max(0, -wait) + customers[i][1]);
        }

        return sum / customers.length;
    }
}