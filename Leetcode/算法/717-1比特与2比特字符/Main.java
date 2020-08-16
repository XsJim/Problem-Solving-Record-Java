public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isOneBitCharacter(new int[] {1, 0, 0}));
        System.out.println(new Solution().isOneBitCharacter(new int[] {1, 1, 1, 0}));
    }
}

class Solution {
    // 题目要求给定的字符串是否无论如何都是由一个一比特字符 0 来结尾
    // 由题目：
    // 如果当前位置为 1 ，则它的下一个数字一定要和这个 1 组合成为一个二比特字符
    // 如果当前位置为 0 ，则它的下一个数字一定是独立的或者是另一个二比特字符的首字符
    // 再由题目要求可知：
    // 如果当前位置为 1 ，则要求它的位置 +2 的地方还可以继续放数字，如果不能，则不符合要求
    // 如果当前位置为 0 ，则它的下一个数字可以是任意数
    // 如果当前位置达到数组长度，则返回 true
    public boolean isOneBitCharacter(int[] bits) {
        return talgo(bits, 0);
    }

    private static boolean talgo(int[] bits, int i) {
        if (i == bits.length) return true;
        if (bits[i] == 1) {
            if (i + 2 >= bits.length) return false;
            else return talgo(bits, i+2);
        } else return talgo(bits, i+1);
    }
}