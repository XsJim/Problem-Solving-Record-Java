public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[] {1,1,2}));
        System.out.println(new Solution().removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
}

class Solution {
    // 去掉排序数组中重复的数字，只保留一个
    // 由于是已排序的，每个数字只保留第一次遇到的即可
    // 所以第一个数字是一定留下的，我们从第二个数字开始判断
    // 设置两个指针，首指针指向第一个，尾指针指向第二个
    // 有两种情况：
    // 如果两指针数字相同，则将第二个指针向后移动一位，接着判断后面的
    // 如果两指针数字不同，则将第二个指针指向的数字放置到第一个指针的后一位
    // 这时，第一个指针向后移动一位，指向的是本轮新出现的数字，第二个指针依然向后移，继续判断之后的
    // 这一过程中，第一个指针指向的，始终是去掉当前重复数字后，剩余数字的最后一个，最终，剩余数字的数量就是该指针的值加 1
    public int removeDuplicates(int[] nums) {
        int prev = 0, current = 1;
        while (current < nums.length) {
            if (nums[current] != nums[prev]) {
                nums[++prev] = nums[current];
            }
            current++;
        }

        return prev+1;
    }
}