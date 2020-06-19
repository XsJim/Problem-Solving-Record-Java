import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().twoCitySchedCost(new int[][] {{10,20},{30,200},{400,50},{30,20}}));
    }
}

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            int aa = a[0] - a[1];
            int bb = b[0] - b[1];
            if (aa > bb) return 1;
            if (aa < bb) return -1;
            return 0;
        });

        int sum = 0;
        int brake = costs.length / 2;

        for (int i = 0; i < brake; i++) sum += (costs[i][0] + costs[i+brake][1]);

        return sum;
    }
}