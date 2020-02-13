public class Main {
    public static void main(String[] args) {
        System.out.print(new Solution().replaceSpace(" We are hap  py.  "));
    }
}

class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == ' ') {
                stringBuilder.append("%20");
            } else stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }
}