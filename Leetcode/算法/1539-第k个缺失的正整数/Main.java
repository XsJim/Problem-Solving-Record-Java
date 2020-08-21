public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthPositive(new int[] {2,3,4,7,11}, 5));
        System.out.println(new Solution().findKthPositive(new int[] {1,2,3,4}, 2));
    }
}

class Solution {
    // 给定一个数组和一个数字 k
    // 问如果从 1 开始数，这个数组中，缺少的第 k 个数字是多少
    // 设置一个表示当前遍历应该出现的值 a ，然后用当前数组的值，减去 a 得到 x
    // 如果 x 等于 0 ，说明当前遍历应该出现的值，和实际出现的值相同，不缺少数字
    // 如果 x 大于 0 ，说明实际出现的值，在应该出现的值之后，这中间缺少了一部分值
    // 缺少的值的个数，是实际出现值减去应该出现值，还是 x
    // 如果 x 小于 k ，说明要求的第 k 个缺少的数字，不在当前应该出现值和实际出现值组成的半闭半开区间内
    // 那么 k 值应该缩小，减去的是当前缺少的值的个数 x
    // 如果 x 大于或等于 k ，则说明要求的值在应该出现值之后或是应该出现值
    // 总之，现在这个值是当前应该出现值 a 加上缺少的数量 k 再减去 1
    public int findKthPositive(int[] arr, int k) {
        int a = 1;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] - a;
            if (x != 0) {
                if (x < k) k -= x;
                else break;
            }
            a = arr[i] + 1;
        }
        return a + k - 1;
    }
}