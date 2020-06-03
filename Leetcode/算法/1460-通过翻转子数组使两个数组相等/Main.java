public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canBeEqual(new int[] {1,2,3,4}, new int[] {2,4,1,3}));
        System.out.println(new Solution().canBeEqual(new int[] {7}, new int[] {7}));
        System.out.println(new Solution().canBeEqual(new int[] {1,12}, new int[] {12,1}));
        System.out.println(new Solution().canBeEqual(new int[] {3,7,9}, new int[] {3,7,11}));
        System.out.println(new Solution().canBeEqual(new int[] {1,1,1,1,1}, new int[] {1,1,1,1,1}));
    }
}

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int i = 0; i < target.length; i++) count[target[i]]++;
        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i]] != 0) count[arr[i]]--;
            else return false;
        }
        return true;
    }
}