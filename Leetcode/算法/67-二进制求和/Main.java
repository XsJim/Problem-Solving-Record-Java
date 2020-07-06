public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
        System.out.println(new Solution().addBinary("1010", "1011"));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        int[] aArr = new int[a.length()];
        int[] bArr = new int[b.length()];
        int ansLen = aArr.length > bArr.length ? aArr.length + 1 : bArr.length + 1;
        char[] ans = new char[ansLen--];
        int i = 0;
        for (char x : a.toCharArray()) aArr[i++] = x - '0';
        i = 0;
        for (char x : b.toCharArray()) bArr[i++] = x - '0';

        int c = 0;
        i = aArr.length - 1; int j = bArr.length - 1;
        while (i >= 0 || j >= 0) {
            int aa = 0, bb = 0;
            if (i >= 0) aa = aArr[i--];
            if (j >= 0) bb = bArr[j--];
            int sum = aa + bb + c;
            if (sum == 0) {
                ans[ansLen--] = '0';
                c = 0;
            }
            else if (sum == 1) {
                ans[ansLen--] = '1';
                c = 0;
            }
            else if (sum == 2) {
                ans[ansLen--] = '0';
                c = 1;
            } else {
                ans[ansLen--] = '1';
                c = 1;
            }
        }

        if (c == 1) ans[ansLen--] = '1';

        return new String(ans, ansLen+1, ans.length-ansLen-1);
    }
}