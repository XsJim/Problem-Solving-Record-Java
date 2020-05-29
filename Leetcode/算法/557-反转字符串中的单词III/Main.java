public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}

class Solution {
    public String reverseWords(String s) {
        char[] cArr = s.toCharArray();
        int left = 0, i = 0;
        while (i < cArr.length) {
            if (cArr[i] == ' ') {
                reverse(cArr, left, i - 1);
                left = i + 1;
            }
            i++;
        }
        reverse(cArr, left, i - 1);
        return new String(cArr);
    }

    private static void reverse(char[] cArr, int l, int r) {
        while (l < r) {
            char temp = cArr[l];
            cArr[l++] = cArr[r];
            cArr[r--] = temp;
        }
    }
}