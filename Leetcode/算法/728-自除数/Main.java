import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().selfDividingNumbers(1, 22));
    }
}

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new LinkedList<>();
        while (left <= right) {
            if (check(left)) ans.add(left);
            left++;
        }
        return ans;
    }

    private static boolean check(int x) {
        int cx = x;
        while (cx != 0) {
            int n = cx % 10;
            cx /= 10;
            if (n == 0 || x % n != 0) return false;
        }
        return true;
    }
}