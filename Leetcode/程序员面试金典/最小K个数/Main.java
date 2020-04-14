import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallestK(new int[] {1,3,5,7,2,4,6,8}, 4)));
    }
}

class Solution {
    public int[] smallestK(int[] arr, int k) {
        sort(arr, 0, arr.length-1);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private static void sort(int[] arr, int l, int r) {
        if (r <= l) return;
        int m = p(arr, l, r);
        sort(arr, l, m - 1);
        sort(arr, m + 1, r);
    }

    private static int p(int[] arr, int l, int r) {
        int i = l, j = r + 1;
        int v = arr[l];
        while (true) {
            while (arr[++i] <= v) if (i == r) break;
            while (arr[--j] > v) if (j == l) break;
            if (i >= j) break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[l] = arr[j];
        arr[j] = v;
        return j;
    }
}