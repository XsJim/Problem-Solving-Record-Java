public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("()"));
        System.out.println(new Solution().checkValidString("(*)"));
        System.out.println(new Solution().checkValidString("(*))"));
    }
}

// 每个 '*' 号都有三种可能的符号
// '(', ')', ' '
// 所以在正常的括号匹配判断中，为这三种情况加入分支判断
// 最终只要知道所有情况中是否有一种可行就行
class Solution {
    public boolean checkValidString(String s) {
        return talgo(s, 0, 0);
    }

    private static boolean talgo(String s, int index, int count) {
        if (s.length() == index) return count == 0;
        char x = s.charAt(index);
        if (x == ')') {
            if (count == 0) return false;
            return talgo(s, index+1, count-1);
        }
        else if (x == '(') {
            return talgo(s, index+1, count+1);
        } else {
            if (count == 0) return talgo(s, index+1, 1) || talgo(s, index+1, 0);
            else return talgo(s, index+1, count+1) || talgo(s, index+1, count-1) || talgo(s, index+1, count);
        }
    }
}