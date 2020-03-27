import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().swapNumbers(new int[] {-1, 2})));
    }
}

class Solution {
    public int[] swapNumbers(int[] numbers) {
        // maybe spill
        // numbers[0] += numbers[1];
        // numbers[1] = numbers[0] - numbers[1];
        // numbers[0] -= numbers[1];

        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}