import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
    }
}

class Solution {
    // 遍历数组，将每个数字放到将它自己作为数组下标时的位置
    // 由于有些数字出现两次，有些一次都没出现，所以当某个数字已经在自己的位置时，就去放置下一个位置的数字
    // 这个条件是，当前位置已经是正确的数字，或者将要放置的位置已经是正确的数字
    // 当放置完毕后，保证了每个出现的数字在自己正确的位置放置，再次遍历数组，就可以通过对比下标和当前数字的关系，来判断哪些数字没有出现
    // 因为所有出现的数字在对应位置均存在
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = i + 1;
            while (x != nums[i] && nums[nums[i]-1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = i + 1;
            if (nums[i] != x) list.add(x);
        }

        return list;
    }
}