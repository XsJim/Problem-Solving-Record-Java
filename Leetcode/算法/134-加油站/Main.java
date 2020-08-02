public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
        System.out.println(new Solution().canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int x = 0;
        w: while (x < gas.length) {
            int o = gas[x];
            int y = x;
            while (true) {
                o -= cost[y];
                if (o < 0) {
                    x = Math.max(y+1, x+1);
                    break;
                }
                y++;
                if (y == gas.length) y = 0;
                if (y == x) break w;
                o += gas[y];
            }
        }

        return x != gas.length ? x : -1;
    }
}