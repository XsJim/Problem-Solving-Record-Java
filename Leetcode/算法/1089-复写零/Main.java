import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(arr));
        new Solution().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {1,2,3};
        System.out.println(Arrays.toString(arr));
        new Solution().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 2; j > i; j--) {
                    arr[j+1] = arr[j];
                }
                i++;
                if (i < arr.length) arr[i] = 0;
            }
        }
    }
}