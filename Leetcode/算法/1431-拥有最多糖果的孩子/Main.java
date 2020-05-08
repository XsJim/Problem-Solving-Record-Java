import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<Boolean> list = new Solution().kidsWithCandies(new int[] {2,3,5,1,3}, 3);
        for (Boolean b : list) {
            System.out.println(b);
        }
    }
}

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) max = candies[i];
        }
        List<Boolean> ans = new LinkedList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}