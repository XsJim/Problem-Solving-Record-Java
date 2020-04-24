import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().pairSums(new int[] {5,6,5}, 11);
        for (List<Integer> list : ans) {
            for (int x : list) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        ans = new Solution().pairSums(new int[] {5,6,5,6}, 11);
        for (List<Integer> list : ans) {
            for (int x : list) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else {
                List<Integer> list = new LinkedList<>();
                list.add(nums[i]); list.add(nums[j]); ans.add(list);
                i++; j--;
            }
        }
        return ans;
    }
}