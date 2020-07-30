import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumAbsDifference(new int[] {4,2,1,3}));
        System.out.println(new Solution().minimumAbsDifference(new int[] {1,3,6,10,15}));
        System.out.println(new Solution().minimumAbsDifference(new int[] {3,8,-10,23,19,-4,-14,27}));
    }
}

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < arr.length; j++) {
            int current = arr[j] - arr[j-1];
            if (current < min) {
                min = current;
                ans.clear();
            }
            if (current == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[j-1]); list.add(arr[j]);
                ans.add(list);
            }
        }
        return ans;
    }

    public List<List<Integer>> minimumAbsDifference_bs(int[] arr) {
        Arrays.sort(arr);
        int x = Math.abs(arr[0] - arr[arr.length-1]);
        List<List<Integer>> ans = new ArrayList<>(); 
        for (int i = 1; i <= x; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                int a = arr[j] + i;
                if (b_s(arr, a, j+1)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[j]); list.add(a);
                    ans.add(list);
                    flag = true;
                }
            }
            if (flag) break;
        }

        return ans;
    }

    private boolean b_s(int[] arr, int key, int left) {
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < key) {
                left = mid + 1;
            }
            else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}