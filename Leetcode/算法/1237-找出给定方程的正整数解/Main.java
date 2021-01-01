import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findSolution(new CustomFunctionImpl(), 5));
    }
}

interface CustomFunction {
    public int f(int x, int y);
}

class CustomFunctionImpl implements CustomFunction {
    public int f(int x, int y) {
        return x + y;
    }
}

// 枚举x, y的可能值
// 将符合条件的x, y添加到答案
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int x = 1, y = 1;
        int n;
        while ((n = customfunction.f(x, y)) <= z) {
            int j = y;
            while (n < z) {
                j++;
                n = customfunction.f(x, j);
            }
            if (n == z) {
                ans.add(List.of(x, j));
            }
            x++;
        }
        return ans;
    }
}