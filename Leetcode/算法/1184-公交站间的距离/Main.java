public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().distanceBetweenBusStops(new int[] {1,2,3,4}, 0, 1));
        System.out.println(new Solution().distanceBetweenBusStops(new int[] {1,2,3,4}, 0, 2));
        System.out.println(new Solution().distanceBetweenBusStops(new int[] {1,2,3,4}, 0, 3));
    }
}

class Solution {

    // 公交车可以顺时针或逆时针行驶，但都是从起点出发直到到达终点
    // 给定的距离数组中，位于 i 的距离是表示从 i 到 (i+1)%n 的距离
    // 按照顺时针，这是从当前位置到下一个位置的距离
    // 按照逆时针，这是从下一个位置到当前位置的距离
    // 所以在计算顺时针的距离时，首先加上当前位置的 distance ，再给当前位置加 1 ，并判断是否等于 n ，若等于，则归 0
    // 在计算逆时针距离时，首先给当前位置减 1 ，并判断是否等于 -1 ，若等于 -1 ，则赋值 n-1 ，再加上改变后的当前位置的 distance
    // 最后，两个距离值中较小的值就是所求的答案
 
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;

        int i = start;
        int len1 = 0;
        while (i != destination) {
            len1 += distance[i];
            if (++i == n) i = 0;
        }

        i = start;
        int len2 = 0;
        while (i != destination) {
            if (--i == -1) i = n - 1;
            len2 += distance[i];
        }

        return Math.min(len1, len2);
    }
}