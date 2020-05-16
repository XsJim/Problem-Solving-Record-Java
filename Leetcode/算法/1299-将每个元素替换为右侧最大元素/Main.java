import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().replaceElements(new int[] {17,18,5,4,6,1})));
    }
}

class Solution {
    public int[] replaceElements(int[] arr) {
        int i = arr.length - 1;
        int max = arr[i];
        arr[i--] = -1;
        while (i >= 0) {
            if (arr[i] > max) {
                int temp = arr[i];
                arr[i] = max;
                max = temp;
            } else arr[i] = max;
            i--;
        }
        return arr;
    }
}