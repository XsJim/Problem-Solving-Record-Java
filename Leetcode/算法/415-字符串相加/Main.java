public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("10", "1"));
        System.out.println(new Solution().addStrings("99", "9"));
        System.out.println(new Solution().addStrings("9", "9"));
    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        char[] ans = new char[Math.max(arr1.length, arr2.length) + 1];
        int i1 = arr1.length - 1, i2 = arr2.length - 1;
        int i3 = ans.length - 1;
        int c = 0;
        while (i1 >= 0 && i2 >= 0) {
            c += ((arr1[i1--] - '0') + (arr2[i2--] - '0'));
            ans[i3--] = (char)((c % 10) + '0');
            c /= 10;
        }
        while (i1 >= 0) {
            c += (arr1[i1--] - '0');
            ans[i3--] = (char)((c % 10) + '0');
            c /= 10;
        }
        while (i2 >= 0) {
            c += (arr2[i2--] - '0');
            ans[i3--] = (char)((c % 10) + '0');
            c /= 10;
        }
        if (c != 0) ans[i3--] = (char)(c + '0');
        return new String(ans, i3+1, ans.length-(i3+1));
    }
}