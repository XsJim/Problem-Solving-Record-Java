import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().orangesRotting(new int[][] {{2,1,1}, {1,1,0}, {0,1,1}}));
        System.out.println(new Solution().orangesRotting(new int[][] {{2,1,1}, {0,1,1}, {1,0,1}}));
        System.out.println(new Solution().orangesRotting(new int[][] {{0,2}}));
    }
}

class Solution {
    // 求所有橘子坏掉所需的分钟数
    // 每个橘子影响它上下左右的好橘子
    // 每一分钟，每个坏橘子都会进行感染动作，但是在之前的分钟里已经进行过感染动作的橘子，没必要继续感染，因为它四周已经没有未感染的橘子
    // 所以在当前的分钟里，只考虑上一分钟新被感染的橘子
    // 建立一个结点，用来存放坏橘子的位置，首先遍历地图，将所有坏橘子的坐标加入队列中，并记录好橘子的个数
    // 遍历完毕后，建立一个记录时间的变量，初始值 0 ，表示还没有开始进行感染动作
    // 让坏橘子进行感染动作的条件有两个：
    // 要有还能正常感染其他橘子的橘子（刚刚被感染的橘子，或者初始化时的坏橘子）
    // 要有可以被感染的橘子，也就是剩余好橘子的数量要大于 0
    // 每一轮，都只检查上一轮新感染的橘子可以感染哪些橘子，并将这些新感染的加入队列，每感染一个，好橘子的数量就要减一
    // 当新感染的橘子数量为 0 ，或好橘子数为 0 时，便说明所有的感染动作都已完成
    // 这时，如果好橘子数不为 0 ，说明这些好橘子是无法被感染的，因为所有的坏橘子都已经判断完毕，返回 -1
    // 反之，所有橘子都被感染，那么存放用时的变量的值，就是所求的答案（进行感染动作的时间已经计入，好橘子数量为 0 ）
    public int orangesRotting(int[][] grid) {
        class Node {
            int x;
            int y;
            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int goodSum = 0;
        Deque<Node> badOrange = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) badOrange.add(new Node(i, j));
                else if (grid[i][j] == 1) goodSum++;
            }
        }

        int min = 0;
        int[] a = new int[] {-1, 1, 0, 0};
        int[] b = new int[] {0, 0, -1, 1};
        while (badOrange.size() > 0 && goodSum > 0) {
            int x = badOrange.size();
            while (x-- > 0) {
                Node current = badOrange.poll();
                for (int i = 0; i < 4; i++) {
                    int xx = current.x + a[i];
                    int yy = current.y + b[i];
                    if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[xx].length && grid[xx][yy] == 1) {
                        grid[xx][yy] = 2;
                        goodSum--;
                        badOrange.add(new Node(xx, yy));
                    }
                }
            }
            min++;
        }
        if (goodSum > 0) return -1;
        return min;
    }
}