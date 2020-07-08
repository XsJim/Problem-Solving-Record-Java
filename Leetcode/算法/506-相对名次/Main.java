import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRelativeRanks(new int[] {5, 4, 3, 2, 1})));
    }
}

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        class Node {
            int index;
            int a;
            Node(int index, int a) {
                this.index = index;
                this.a = a;
            }
        }
        Node[] nNums = new Node[nums.length];

        for (int i = 0; i < nums.length; i++) nNums[i] = new Node(i, nums[i]);

        Arrays.sort(nNums, (a, b) -> {
            return Integer.compare(b.a, a.a);
        });

        String[] ans = new String[nums.length];
        String[] p = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 1; i <= nums.length; i++) {
            ans[nNums[i-1].index] = i > 3 ? (""+i) : p[i-1];
        }

        return ans;
    }
}