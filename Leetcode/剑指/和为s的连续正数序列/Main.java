import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().findContinuousSequence(9)));
        System.out.println(Arrays.deepToString(new Solution().findContinuousSequence(15)));
    }
}

class Solution {
    public int[][] findContinuousSequence(int target) {
        int n = target / 2 + 1;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i = 1, j = 2, sum = 3;
        while (j <= n && i < j) {
            if (sum > target) {
                sum -= i;
                i++;
            }
            else if (sum < target) {
                j++;
                sum += j;
            }
            else {
                int[] array = new int[j-i+1];
                for (int x = 0, y = i; y <= j; x++, y++) {
                    array[x] = y;
                }
                arrayList.add(array);
                sum -= i;
                i++;
                j++;
                sum += j;
            }
        }
        int[][] re = new int[arrayList.size()][];
        for (int x = 0; x < arrayList.size(); x++) {
            re[x] = arrayList.get(x);
        }
        return re;
    }
}