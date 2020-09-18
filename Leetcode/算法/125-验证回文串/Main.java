public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
    }
}

class Solution {
    // 设置两个指针，循环对比指针指向的字符是否相同
    // 如果遇上空字符或者符号则跳过
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            boolean l = isC(s.charAt(left));
            boolean r = isC(s.charAt(right));
            if (!l) {
                left++;
            }
            if (!r) {
                right--;
            }
            if (l && r) {
                if (down(s.charAt(left)) != down(s.charAt(right))) return false;
                left++; right--;
            }
        }

        return true;
    }

    private static boolean isC(char c) {
        return (c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9');
    }

    private static char down(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c-'A'+'a');
        return c;
    }
}