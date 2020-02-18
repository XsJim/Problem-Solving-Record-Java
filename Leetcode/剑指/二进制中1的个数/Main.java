public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.hammingWeight_2(0b00000000000000000000000000001011));
        System.out.println(Solution.hammingWeight_2(3));
        System.out.println(Solution.hammingWeight_2(0x3));
    }
}

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n & 1;
            n >>>= 1;
        }
        return sum;
    }

    /**
     * 无符号数，一个数和比它小一的数进行 & 运算，会消去一位处于低位的 1
     * @param n 输入的是一个无符号整数，即非负数
     * @return 二进制表示中 1 的个数
     */
    public static int hammingWeight_2(int n) {
        int sum = 0;
        while (n != 0) {
            n &= (n - 1);
            sum++;
        }
        return sum;
    }
}