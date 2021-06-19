import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("2", "3"));
        System.out.println(new Solution().multiply("123", "456"));
    }
}

// 按照一般的乘法运算，列竖式进行
// 每次选取一个数中的一位，去乘另一个数的所有位，得到一个结果，将结果加到总的答案中
// 每次得到结果后，都要在结果后补 0 ，第一次补 0 个 0 ，第二次补 1 个 0
// 最后将答案输出
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "";
        if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) return "0";

        ArrayDeque<Integer> ans = new ArrayDeque<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            if (x == 0) continue;
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int j = num1.length() - 1; j > i; j--) queue.add(0);
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int m = x * y;
                carry += m;

                queue.add(carry%10);
                carry /= 10;
            }
            if (carry != 0) queue.add(carry);
            if (ans.isEmpty()) {
                while (!queue.isEmpty()) ans.add(queue.poll());
            } else {
                ArrayDeque<Integer> currentAns = new ArrayDeque<>();

                carry = 0;
                while (!ans.isEmpty() && !queue.isEmpty()) {
                    int a = ans.poll() + queue.poll();
                    carry += a;

                    currentAns.add(carry%10);
                    carry /= 10;
                }

                while (!ans.isEmpty()) {
                    carry += ans.poll();
                    currentAns.add(carry%10);
                    carry /= 10;
                }

                while (!queue.isEmpty()) {
                    carry += queue.poll();
                    currentAns.add(carry%10);
                    carry /= 10;
                }

                if (carry != 0) currentAns.add(carry);

                ans = currentAns;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!ans.isEmpty()) {
            sb.append(ans.removeLast());
        }

        return sb.toString();
    }
}