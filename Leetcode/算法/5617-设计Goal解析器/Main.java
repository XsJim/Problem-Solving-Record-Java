public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().interpret("G()(al)"));
        System.out.println(new Solution().interpret("G()()()()(al)"));
        System.out.println(new Solution().interpret("(al)G(al)()()G"));
    }
}

// 遍历字符串并按照规定解析即可
class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            char x = command.charAt(i);
            if (x == 'G') sb.append('G');
            else if (x == '(') {
                i++;
                x = command.charAt(i);
                if (x == 'a') {
                    sb.append("al");
                    i += 2;
                } else {
                    sb.append('o');
                }
            } else sb.append(x);
            i++;
        }

        return sb.toString();
    }
}