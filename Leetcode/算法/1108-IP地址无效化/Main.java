public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().defangIPaddr("1.1.1.1"));
        System.out.println(new Solution().defangIPaddr("255.100.50.0"));
    }
}

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char x = address.charAt(i);
            if (x == '.') sb.append("[.]");
            else sb.append(x);
        }
        return sb.toString();
    }
}