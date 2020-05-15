import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().permute(new int[] {1,2,3});
        for (List<Integer> list : ans) {
            for (int i : list) System.out.print(i+" ");
            System.out.println(); 
        }
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        boolean[] flag = new boolean[nums.length];
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[i] = true;
            arr[0] = i;
            talgo(1, flag, nums, arr, ans);
            flag[i] = false;
        }
        return ans;
    }

    private static void talgo(int x, boolean[] flag, int[] nums, int[] arr, List<List<Integer>> ans) {
        if (x == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) list.add(nums[arr[i]]);
            ans.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                arr[x] = i;
                talgo(x+1, flag, nums, arr, ans);
                flag[i] = false;
            }
        }
    }
}