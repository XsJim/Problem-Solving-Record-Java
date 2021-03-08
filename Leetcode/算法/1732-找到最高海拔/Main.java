public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().largestAltitude(new int[] {-5,1,5,0,-7}));
        System.out.println(new Solution().largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
    }
}

class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int l = 0;
        for (int i = 0; i < gain.length; i++) {
            l = gain[i] + l;
            if (l > max) max = l;
        }

        return max;
    }
}