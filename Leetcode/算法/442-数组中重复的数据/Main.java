import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }
}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        List<Integer> list = new LinkedList<>();
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] == -1) i++;
            else {
                if (nums[i] == nums[nums[i]-1]) {
                    list.add(nums[i]);
                    nums[nums[i]-1] = -1;
                    i++;
                } else {
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return list;
    }
}