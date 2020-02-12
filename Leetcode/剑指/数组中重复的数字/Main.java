public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber(new int[] {2, 3, 1, 0, 2, 5, 3}));
    }
}

class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] mark = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mark[i] = 0;
        }

        int re = -1;

        for (int i : nums) {
            mark[i]++;
            if (mark[i] > 1) {
                re = i;
                break;
            }
        }

        return re;
    }
}