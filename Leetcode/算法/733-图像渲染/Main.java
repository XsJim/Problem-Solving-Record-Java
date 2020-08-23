import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2)));
    }
}

class Solution {
    // 深度优先搜索
    // 将所有和初始区块颜色相同且相连的区块的颜色改为给定颜色
    // 如果给定的颜色和初始区块的颜色相同，那么无需更改
    // 否则，从初始区块开始，逐步扩展到相连的区块
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) talgo(image, sr, sc, newColor, new int[] {-1, 1, 0, 0}, new int[] {0, 0, -1, 1});
        return image;
    }

    private static void talgo(int[][] image, int x, int y, int newColor, int[] a, int[] b) {
        int oldColor = image[x][y];
        image[x][y] = newColor;
        for (int i = 0; i < 4; i++) {
            int xx = x + a[i];
            int yy = y + b[i];
            if (xx >= 0 && xx < image.length && yy >= 0 && yy < image[xx].length && image[xx][yy] == oldColor) {
                talgo(image, xx, yy, newColor, a, b);
            } 
        }
    }
}