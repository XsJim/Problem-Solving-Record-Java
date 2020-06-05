public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findLucky(new int[] {2,2,3,4}));
        System.out.println(new Solution().findLucky(new int[] {1,2,2,3,3,3}));
        System.out.println(new Solution().findLucky(new int[] {2,2,2,3,3}));
        System.out.println(new Solution().findLucky(new int[] {5}));
        System.out.println(new Solution().findLucky(new int[] {7,7,7,7,7,7,7}));
    }
}

class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int i = 0; i < arr.length; i++) count[arr[i]]++;
        for (int i = 500; i > 0; i--) if (count[i] == i) return i;
        return -1;
    }
}