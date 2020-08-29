public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findPoisonedDuration(new int[] {1,4}, 2));
        System.out.println(new Solution().findPoisonedDuration(new int[] {1,2}, 2));
    }
}

class Solution {
    // 每次攻击造成的伤害，并不是由当前攻击时间决定，而是由下次攻击时间决定的
    // 如果当前攻击时间大于或等于上次攻击持续时间，那么上次攻击会造成全部的持续伤害
    // 如果小于，那么上次的攻击只会造成此次攻击时间和上次攻击时间的差的持续伤害
    // 而最终的一次攻击，总是会造成全额的伤害
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) return 0;
        int n = timeSeries[0] + duration;
        int sum = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] >= n) sum += duration;
            else sum += (timeSeries[i]-timeSeries[i-1]);
            n = timeSeries[i] + duration;
        }
        sum += duration;
        return sum;
    }
}