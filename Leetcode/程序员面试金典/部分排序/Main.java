import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().subSort(new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19})));
    }
}

class Solution {
    public int[] subSort(int[] array) {
        if (array.length == 0) return new int[] {-1, -1};
        int l = 1, r = array.length - 2;
        while (l < array.length && array[l] >= array[l-1]) l++;
        while (r >= 0 && array[r] <= array[r+1]) r--;
        if (l == array.length) return new int[] {-1, -1};

        int min = array[l], max = array[r];
        for (int i = l + 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        for (int i = r; i >= 0; i--) {
            if (array[i] > max) max = array[i];
        }
        l--; r++;
        while (l >= 0 && array[l] > min) l--;
        while (r < array.length && array[r] < max) r++;
        l++; r--;
        return new int[] {l, r};
    }
}