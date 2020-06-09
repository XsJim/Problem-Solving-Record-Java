public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println(new Solution().calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
    }
}

class Solution {
    public int calPoints(String[] ops) {
        int[] stack = new int[ops.length];
        int sum = 0, l;
        int i = -1;
        for (String s : ops) {
            char a = s.charAt(0);
            if (a == '+') {
                l = stack[i] + stack[i-1];
                stack[++i] = l;
            }
            else if (a == 'D') {
                l = stack[i] * 2;
                stack[++i] = l;
            }
            else if (a == 'C') {
                l = -1 * stack[i--];
            } else {
                l = valueOf(s);
                stack[++i] = l;
            }
            sum += l;
        }
        return sum;
    }

    private static int valueOf(String s) {
        char[] sArr = s.toCharArray();
        int sum = 0, i = 0;
        if (sArr[0] == '-') i++;
        while (i < sArr.length) {
            sum *= 10;
            sum += (sArr[i] - '0');
            i++;
        }
        if (sArr[0] == '-') sum *= -1;
        return sum;
    }
}