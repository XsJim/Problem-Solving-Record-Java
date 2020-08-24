public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1}, 3));
    }
}

class Solution {
    // 最直接的思路：
    // 首先，遍历数组，得到所有不生气时的顾客总数
    // 再次遍历数组，当某处生气时，就假设从此处使用不生气能力，然后计算从此处开始，一直到不生气能力用完时的这一区间内所有原本生气的顾客总数
    // 拿到这个数后，和之前的值做比较，看看如果从此出开始不生气会新得到的满意顾客数量是否比从其他地方开始大
    // 如果大，则将其赋给这个最大值
    // 经过这一轮遍历，就可得到，在这个能力范围内，可以将不满意顾客变为满意的最大数量，然后将这个数和第一轮遍历得到数相加，便得答案
    // 优化：
    // 在第二轮遍历中，每次一遇到生气单元，就要开始计算这之后且在不生气能力使用完之前，可以使顾客变满意的最大数量
    // 这需要判断范围内的所有单元
    // 会出现不断重复计算一些单元格的情况，最坏的情况，变不生气的时间很长，且店长每分钟都在生气，那么每次都需要从当前位置求和到数组结束
    // 其实需要的就是一个区间的值，所以，使用数组前缀和来计算
    // 前缀和数组的内容是，包括当前位置，向后直到数组结束的所有生气单元的顾客总和
    // 那么要求一个区间的顾客数，就可以使用当前位置的顾客数，减去向后 X 个单位的前缀和，便可得到从当前位置开始，区间长度为 X 的使满意的顾客数量
    // 其他步骤和直接的思路相同
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        boolean flag = false;
        int[] sums = new int[customers.length];
        for (int i = customers.length - 1, prev = 0; i >= 0; i--) {
            sums[i] = prev;
            if (grumpy[i] == 0) sum += customers[i];
            else {
                sums[i] += customers[i];
                prev = sums[i];
                flag = true;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                int r = i + X;
                int current_sum = sums[i];
                if (r < customers.length) current_sum -= sums[r]; 
                if (current_sum > max) {
                    max = current_sum;
                }
            }
        }

        if (flag) sum += max;
        return sum;
    }
}