import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][] {{1, 0}}));
        System.out.println(new Solution().canFinish(2, new int[][] {{1, 0}, {0, 1}}));
    }
}

//题解中根据拓扑排序算法提取出的深度优先搜索
// 给每个点定义三个状态：
//   1. 0 表示该点还未搜索
//   2. 1 表示该点正在被搜索
//   3. 2 表示该点已经被搜索完成
// 从任意点开始搜索，将该点标记为 1 ，接着，依次搜索该点指向的点，这些点有三种可能状态：
//   1. 状态 0 ：该点未被搜索过，可以搜索，说明这个点是第一次遇到
//   2. 状态 1 ：该点正在被搜索，说明该点出现在了当前点之前（该点有一条指向当前点的路径），同时，该点出现在了当前点的可达点集中，说明当前点也可以到达该点。此时，就发现了环路
//   3. 状态 2 ：该点已经被搜索过，且由它开始的点是无环路的
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] states = new int[numCourses];

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] flag = new boolean[] {true};
        for (int i = 0; i < numCourses; i++) {
            if (states[i] == 0) {
                dfs(i, edges, states, flag);
                if (!flag[0]) break;
            }
        }

        return flag[0];
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> edges, int[] states, boolean[] flag) {
        states[i] = 1;
        for (int x : edges.get(i)) {
            if (states[x] == 0) {
                dfs(x, edges, states, flag);
                if (!flag[0]) return;
            }
            else if (states[x] == 1) {
                flag[0] = false;
                return;
            }
        }

        states[i] = 2;
    }
}

// 自己想的深度优先搜索
class SolutionA {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] map = new boolean[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            map[prerequisites[i][0]][prerequisites[i][1]] = true;
        }

        boolean[] flag = new boolean[numCourses];
        boolean[] can = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!can[i]) {
                flag[i] = true;

                if (!dfs(map, flag, i, can)) return false;
                else can[i] = true;

                flag[i] = false;
            }
        }

        return true;
    }

    private static boolean dfs(boolean[][] map, boolean[] flag, int i, boolean[] can) {
        for (int j = 0; j < map[i].length; j++) {
            if (map[i][j]) {
                if (flag[j]) return false;

                flag[j] = true;
                if (!can[j]) {
                    if (!dfs(map, flag, j, can)) return false;
                    else can[j] = true;
                }
                flag[j] = false;
            }
        }

        return true;
    }
}