public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[] {3,6,7,11}, 8));
        System.out.println(new Solution().minEatingSpeed(new int[] {30,11,23,4,20}, 5));
        System.out.println(new Solution().minEatingSpeed(new int[] {30,11,23,4,20}, 6));
    }
}

class Solution {
    // 求一个能在限定时间内，把所有香蕉吃完的最小吃香蕉速度
    // 使用二分法枚举这个可能的最小值
    // 最小的可能值为 1 ，即每小时吃一根
    // 最大的可能值为所有香蕉堆中，最多的一堆的个数
    // 吃完一堆后，不论用时是否为 1 小时，都要停下
    // 如果要保证所有的都吃完，每小时吃的数量等于这个最大值即可，否则说明没有解决方案
    // 在确定二分区间后，就开始枚举查值
    // 枚举的是每小时吃的速度，要确定速度是否可行，就要求出这个时间下，吃完所有香蕉需要的时间
    // 遍历整个数组，每一堆的用时都是该堆香蕉数量除以每小时香蕉摄入量再向上取整得到，所以每堆香蕉至少也要一个小时
    // 得到当前枚举值的摄入时间后，就可以和要求的时间进行对比
    // 大于要求时间，说明当前枚举的每小时摄入量还太小，要将左边界增大
    // 小于或等于要求时间，说明当前的枚举值是满足要求的，但是可能还可以进一步缩小这个摄入量，所以要将右边界减小
    // 但是在剩余区间内也可能已经没有符合要求的值，所以在满足条件时，就及时保存这个值
    // 由于改变答案是在枚举值满足条件的情况下，所以只可能右边界减小，如果没有出现下一个满足条件的值，那么它保存的就是答案
    // 如果又出现了一个满足条件的值，那么这个新值一定是小于当前保存值的，所以设置这个变量可以保证答案的正确性
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > r) r = piles[i];
        }
        int ans = r;
        while (l <= r) {
            int k = (l + r) / 2;
            int h = talgo(piles, k);
            if (h > H) l = k + 1;
            else {
                ans = k;
                r = k - 1;
            }
        }

        return ans;
    }

    private static int talgo(int[] piles, int k) {
        int h = 0;
        
        for (int i = 0; i < piles.length; i++) {
            h += ((piles[i] + k - 1) / k);
        }

        return h; 
    }
}