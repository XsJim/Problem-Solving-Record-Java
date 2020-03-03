public class Main {
    public static void main(String[] args) {
        System.out.println("\""+new Solution().reverseWords(" the  sky   is blue    ")+"\"");
        System.out.println("\""+new Solution().reverseWords("  hello world!  ")+"\"");
        System.out.println("\""+new Solution().reverseWords("the sky is blue")+"\"");
        System.out.println("\""+new Solution().reverseWords("a good   example")+"\"");
        System.out.println("\""+new Solution().reverseWords("")+"\"");
    }
}

class Solution {
    public String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]);
            if (i - 1 >= 0) stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
}