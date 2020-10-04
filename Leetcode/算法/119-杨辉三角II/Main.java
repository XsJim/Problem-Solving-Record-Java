import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(0));
        System.out.println(new Solution().getRow(1));
        System.out.println(new Solution().getRow(2));
        System.out.println(new Solution().getRow(3));
        System.out.println(new Solution().getRow(33));
    }
}

class Solution {
    // 根据二项展开式和杨辉三角的关系，直接递推得出杨辉三角的某一行
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int prev = 1;
        int index = 1;
        while (index < rowIndex) {
            int current = (int)(1.0 * prev * (rowIndex - index + 1) / index);
            ans.add(current);
            prev = current;
            index++;
        }
        if (rowIndex != 0) ans.add(1);

        return ans;
    }
}