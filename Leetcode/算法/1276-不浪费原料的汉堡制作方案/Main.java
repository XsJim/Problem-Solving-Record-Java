import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfBurgers(16, 7));
        System.out.println(new Solution().numOfBurgers(17, 4));
        System.out.println(new Solution().numOfBurgers(4, 17));
        System.out.println(new Solution().numOfBurgers(0, 0));
        System.out.println(new Solution().numOfBurgers(2, 1));
    }
}

class Solution {
    // 设可制作大汉堡的个数是 x ，小汉堡是 y
    // 每个汉堡都需要夹一块奶酪，奶酪的总块数是 cheeseSlices ，所以有方程一：
    // x + y = cheeseSlices
    // 大汉堡夹 4 块番茄，小汉堡夹 2 块番茄，番茄总数 tomatoSlices ，所以有方程二：
    // 4x + 2y = tomatoSlices
    // 整理两方程得（避开加法、乘法）：
    // x = tomatoSlices / 2 - cheeseSlices
    // y = cheeseSlices - x
    // 如果要将所有材料完全用完，由上式，得出要满足的条件：
    // 1. tomatoSlices 是偶数
    // 2. tomatoSlices / 2 >= cheeseSlices
    // 3. cheeseSlices >= x 即 cheeseSlices >= tomatoSlices / 4
    // 程序首先判定给定数字是否满足条件，再进一步计算答案
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();
        int two = tomatoSlices / 2;
        if ((tomatoSlices & 1) == 1 || cheeseSlices > two || cheeseSlices < two / 2) return ans;
        two -= cheeseSlices;
        ans.add(two);
        ans.add(cheeseSlices-two);
        return ans;
    }
}