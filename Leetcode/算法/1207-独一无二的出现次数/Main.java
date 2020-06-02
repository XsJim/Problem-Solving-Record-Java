public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[] {1,2,2,1,1,3}));
        System.out.println(new Solution().uniqueOccurrences(new int[] {1,2}));
        System.out.println(new Solution().uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0}));
    }
}

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int x : arr) count[x+1000]++;
        boolean[] flag = new boolean[1001];
        for (int x : count) {
            if (x != 0) {
                if (flag[x]) return false;
                else flag[x] = true;
            }
        }
        return true;
    }
}