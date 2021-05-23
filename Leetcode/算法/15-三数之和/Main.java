import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[] {-1,0,1,2,-1,-4}));
        System.out.println(new Solution().threeSum(new int[0]));
        System.out.println(new Solution().threeSum(new int[] {0}));
    }
}

// 为了防止重复，首先将数组排序
// 依次选取数组元素，作为答案的第一个数，由于答案需要三个数字组成，所以第一个数最远只能为数组的倒数第三个数
// 为了最终答案不包含重复的序列，需要确保每次选取的第一个数是不同的
// 接下来选取后两个数字：
//   先选择紧跟在第一个数字之后的元素作为第二个数字，同样为了最终答案不重复，第二个数字也需要每次都不相同
//   然后选择数组的最后一个元素作为第三个元素
//   最终的答案序列是序列中的三数之和为 0 ，那么就要求后两个数字之和是第一个数字的相反数，设这个数字为 target
// 所以现在的目标是：在一段数组中，找到所有和为 target 的元素对，且每个元素对都不同
//   现在第二个数字是该段数组的首元素，第三个数字是该段数组的末元素
//   如果它们的和大于 target ，为了使和更接近 target ，只能减小第三个数字，即指向第三个数字的指针前移
//   如果它们的和小于 target ，为了使和更接近 target ，只能增加第二个数字，即指向第二个数字的指针后移
//   如果和等于 target ，那么就找到了一对序列，这对序列和第一个数字组成一个唯一的三元组，为了不重复，也为了得到下一对序列，必须增大第二个数字，减小第三个数字
//   重复以上操作，直到指向第二个数字和第三个数字的指针相遇
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        Arrays.sort(nums);
        for (int i = 0, preA = nums[0] - 1; i < nums.length - 2; i++) {
            if (preA != nums[i]) {
                preA = nums[i];
                int j = i + 1;
                int z = nums.length - 1;
                int preB = nums[j] - 1;
                int target = -nums[i];
                while (j < z) {
                    if (nums[j] != preB) {
                        preB = nums[j];

                        while (j < z && (nums[j] + nums[z]) > target) z--;
                        if (j < z && (nums[j] + nums[z]) == target) {
                            ans.add(List.of(nums[i], nums[j], nums[z]));
                            z--;
                            while (j < z && nums[z] == nums[z+1]) z--;
                        }
                    }
                    j++;
                }

            }
        }

        return ans;
    }
}