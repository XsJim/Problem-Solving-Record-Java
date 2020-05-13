import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().subsets(new int[] {1,2,3});
        for (List<Integer> list : lists) {
            for (Integer i : list) System.out.print(i+" ");
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int flag = (int)Math.pow(2, nums.length)-1;
        List<List<Integer>> ans = new LinkedList<>();
        while (flag >= 0) {
            int j = flag;
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((j & 1) == 1) list.add(nums[i]);
                j >>= 1;
            }
            ans.add(list);
            flag--;
        }
        return ans;
    }
}