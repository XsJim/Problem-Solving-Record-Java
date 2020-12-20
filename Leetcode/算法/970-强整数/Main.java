import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().powerfulIntegers(2,3,10));
        System.out.println(new Solution().powerfulIntegers(2,1,10));
        System.out.println(new Solution().powerfulIntegers(3,5,15));
    }
}

// 枚举每一个可能值，将已经加入答案链表的数映射到散列表
// 如果判断该值已经加入到答案链表中，就不再将其加入
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<>();

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i <= bound; i *= x) {
            int j = 1;
            int sum = i + j;
            while (sum <= bound) {
                if (map.get(sum) == null) {
                    ans.add(sum);
                    map.put(sum, true);
                }
                j *= y;
                sum = i + j;
                if (y == 1) break;
            }
            if (x == 1) break;
        }

        return ans;
    }
}