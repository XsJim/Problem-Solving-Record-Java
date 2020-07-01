import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseOnlyLetters("ab-cd"));
        System.out.println(new Solution().reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] sArr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char x : sArr) {
            if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) stack.push(x);
        }
        for (int i = 0; i < sArr.length; i++) {
            char x = sArr[i];
            if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) sArr[i] = stack.pop();
        }
        return new String(sArr);
    }
}