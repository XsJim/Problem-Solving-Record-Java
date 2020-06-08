public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("A"));
        System.out.println(new Solution().titleToNumber("AB"));
        System.out.println(new Solution().titleToNumber("ZY"));
    }
}

class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        char[] sArr = s.toCharArray();
        for (int i = sArr.length - 1, j = 1; i >= 0; i--, j *= 26) {
            sum += (sArr[i] - 'A' + 1) * j;
        }
        return sum;
    }
}