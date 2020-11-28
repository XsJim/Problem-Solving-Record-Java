public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(6));
        System.out.println(new Solution().isUgly(8));
        System.out.println(new Solution().isUgly(14));
    }
}

// 首先负数和0不是丑数
// 然后缩小给定数，看能否变为 1
// 每轮除 2, 3, 5
// 如果当前数不是以上三个数中任意一个的倍数，则说明它不是丑数
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            }
            else if (num % 3 == 0) {
                num /= 3;
            }
            else if (num % 5 == 0) {
                num /= 5;
            } else break;
        }

        return num == 1;
    }
}