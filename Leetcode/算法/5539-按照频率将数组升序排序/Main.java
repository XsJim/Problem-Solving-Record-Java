import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[] {1,1,2,2,2,3})));
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[] {2,3,1,3,2})));
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[] {-1,1,-6,4,5,-6,1,4,1})));
    }
}

// 散列计数，排序
// 为了加快排序，创建新数组，将存在的数加入数组中后再进行排序
class Solution {
    public int[] frequencySort(int[] nums) {
        class Node {
            int num;
            int count;
            Node(int num) {
                this.num = num;
                this.count = 0;
            }
        }

        Node[] counts = new Node[201];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] + 100;
            if (counts[index] == null) {
                len++;
                counts[index] = new Node(nums[i]);
            }
            counts[index].count++;
        }
        Node[] copy = new Node[len];
        for (int i = 0, j = 0; i < 201; i++) {
            if (counts[i] != null) {
                copy[j++] = counts[i];
            }
        }
        Arrays.sort(copy, (a, b) -> {
            if (a.count == b.count) return Integer.compare(b.num, a.num);
            return Integer.compare(a.count, b.count);
        });
        int[] ans = new int[nums.length];
        for (int i = 0, j = 0; i < len; i++) {
            int curr = copy[i].count;
            while (curr-- > 0) ans[j++] = copy[i].num;
        }

        return ans;
    }
}