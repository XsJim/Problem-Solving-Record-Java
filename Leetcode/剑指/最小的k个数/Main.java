import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((new Solution().getLeastNumbers(new int[] {4,5,1,6,2,7,3,8}, 4))));
    }
}

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] arr_copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) arr_copy[i] = arr[i];
        Arrays.sort(arr_copy);
        int[] re = new int[k];
        for (int i = 0; i < k; i++) {
            re[i] = arr_copy[i];
        }
        return re;
    }
}