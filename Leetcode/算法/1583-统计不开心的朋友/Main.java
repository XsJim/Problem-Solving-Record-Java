public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().unhappyFriends(4, new int[][] {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}}, new int[][] {{0, 1}, {2, 3}}));
        System.out.println(new Solution().unhappyFriends(2, new int[][] {{1}, {0}}, new int[][] {{1, 0}}));
        System.out.println(new Solution().unhappyFriends(4, new int[][] {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}}, new int[][] {{1, 3}, {0, 2}}));
    }
}

// 1. 首先，建立一个 n 行 2 列的数组 py
//   py 的行下标 i 表示人的编号
//   列下标为 0 的元素 j 表示在关系表 pairs 中， i 和 j 是朋友
//   如果 py[i][0] = j 根据题目， py[j][0] = i
//   列下标为 1 的元素 x 表示 j 在 i 的亲近程度表中的位置，即亲近程度的数值表示
// 2. 填充数组 py 后，遍历 py
//   对于当前行的人物 i ， i 更亲近 i 的亲近程度表中位于 j 之前的人物
//   这些人（取 z 表示这些人中的某一个）已经满足了题目给定的，可能使 i 不开心的第一个条件，即亲近程度要强于 i 当前的朋友 j
//   要确定 i 是否是不开心的，还需要确定在 z 的亲近程度表中， z 对 i 的亲近程度是否强于 z 对 z 的配对朋友（用 k 表示）的亲近程度（第二个条件）
//   z 对 k 的亲近程度，通过查 py[z][1] 可知
//   z 对 i 的亲近程度，需要遍历 z 的亲近程度表计算
//   若计算得 z 对 k 的亲近程度弱于 z 对 i 的亲近程度，那么便可确定 i 是不快乐的了
//   这之后也没有必要再继续判断接下来的 z 了，因为 i 已经是不开心的了
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] py = new int[n][2];
        for (int i = 0, j = n / 2; i < j; i++) {
            py[pairs[i][0]][0] = pairs[i][1];
            py[pairs[i][1]][0] = pairs[i][0];
        }

        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = 0, z = n - 1; j < z; j++) {
                if (preferences[i][j] != py[i][0]) x++;
                else break;
            }

            py[i][1] = x;
        }

        int notHappy = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0, z = n - 1; j < z; j++) {
                if (preferences[i][j] != py[i][0]) {
                    int x = preferences[i][j];
                    int iINx = 0;
                    for (int y = 0; y < z; y++) {
                        if (preferences[x][y] != i) iINx++;
                        else break;
                    }

                    int xF = py[x][1];

                    if (iINx < xF) {
                        notHappy++;
                        break;
                    }
                } else break;
            }
        }

        return notHappy;
    }
}