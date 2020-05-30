import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] a = new char[] {'h','e','l','l','o'};
        char[] b = new char[] {'H','a','n','n','a','h'};
        new Solution().reverseString(a);
        new Solution().reverseString(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}