public class Main {
    public static void main(String[] args) {
        System.out.println("\""+new Solution().reverseLeftWords("abcdefg", 2)+"\"");
        System.out.println("\""+new Solution().reverseLeftWords("lrloseumgh", 6)+"\"");
    }
}

class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}