import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().freqAlphabets("10#11#12"));
        System.out.println(new Solution().freqAlphabets("1326#"));
        System.out.println(new Solution().freqAlphabets("25#"));
        System.out.println(new Solution().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}

class Solution {
    public String freqAlphabets(String s) {
        Stack<String> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        int i = sArr.length - 1;
        while (i >= 0) {
            if (sArr[i] == '#') {
                stack.push(""+(char)((sArr[i-2]-'0')*10+(sArr[i-1]-'0')+'a'-1));
                i -= 3;
            } else stack.push(""+(char)(sArr[i--]-'0'+'a'-1));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}