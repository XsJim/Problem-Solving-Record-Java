public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new Solution().balancedStringSplit("RLLLLRRRLR"));
        System.out.println(new Solution().balancedStringSplit("LLLLRRRR"));
    }
}

class Solution {
    public int balancedStringSplit(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'R') r++;
            else l++;
            if (l == r) {
                max++; l = 0; r = 0;
            }
        }
        return max;
    }
}