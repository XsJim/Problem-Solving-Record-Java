import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().generate(1));
        System.out.println(new Solution().generate(2));
        System.out.println(new Solution().generate(3));
        System.out.println(new Solution().generate(4));
        System.out.println(new Solution().generate(5));
        System.out.println(new Solution().generate(6));
    }
}

class Solution {
    // 模拟，由上至下逐层递推即可
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            int current_index = 1;
            int prev_index = 0;
            while ((prev_index + 1) < prev.size()) {
                current.add(prev.get(prev_index)+prev.get(prev_index+1));
                current_index++;
                prev_index++;
            }
            if (current_index <= i) current.add(1);
            lists.add(current);
            prev = current;
        }

        return lists;
    }
}