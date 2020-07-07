public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findJudge(2, new int[][] {{1,2}}));
        System.out.println(new Solution().findJudge(3, new int[][] {{1,3},{2,3}}));
        System.out.println(new Solution().findJudge(3, new int[][] {{1,3},{2,3},{3,1}}));
        System.out.println(new Solution().findJudge(3, new int[][] {{1,2},{2,3}}));
        System.out.println(new Solution().findJudge(4, new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] count = new int[N+1][2];

        for (int i = 0; i < trust.length; i++) {
            count[trust[i][0]][0]++;
            count[trust[i][1]][1]++;
        }
        for (int i = 1; i <= N; i++) {
            if (count[i][0] == 0 && count[i][1] == (N - 1)) return i;
        }
        return -1;
    }
}