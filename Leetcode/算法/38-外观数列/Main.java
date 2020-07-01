import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(1));
        System.out.println(new Solution().countAndSay(2));
        System.out.println(new Solution().countAndSay(3));
        System.out.println(new Solution().countAndSay(4));
        System.out.println(new Solution().countAndSay(5));
        System.out.println(new Solution().countAndSay(30));
    }
}

class Solution {
    public String countAndSay(int n) {
        char[] a = new char[10000];
        char[] b = new char[10000];
        char[] c = a, d = b, e;
        a[0] = '1';
        int i = 1;
        while (--n > 0) {
            char prev = c[0]; int count = 1;
            int z = 0;
            for (int j = 1; j < i; j++) {
                if (c[j] == prev) count++;
                else {
                    z = add(d, z, count, prev);
                    prev = c[j]; count = 1;
                }
            }
            i = add(d, z, count, prev);
            e = c; c = d; d = e;
        }
        return new String(c, 0, i);
    }

    private static int add(char[] a, int z, int count, char prev) {
        Stack<Integer> stack = new Stack<>();

        while (count != 0) {
            stack.push(count%10);
            count /= 10;
        }

        while (!stack.empty()) a[z++] = (char)(stack.pop()+'0');
        a[z++] = prev;
        return z;
    }
}