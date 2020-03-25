import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2)));
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] a = new int[] {0, 0, 1, -1};
        int[] b = new int[] {1, -1, 0, 0};
        dfs(image, sr, sc, newColor, image[sr][sc], a, b);
        return image;
    }

    private static void dfs(int[][] image, int x, int y, int newColor, int oldColor, int[] a, int[] b) {
        if (image[x][y] != oldColor || image[x][y] == newColor) return;
        image[x][y] = newColor;
        for (int i = 0; i < 4; i++) {
            int xx = x + a[i];
            int yy = y + b[i];
            if (xx >= 0 && xx < image.length && yy >= 0 && yy < image[0].length) {
                dfs(image, xx, yy, newColor, oldColor, a, b);
            }
        }
    }
}