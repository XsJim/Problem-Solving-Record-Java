import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] rectangle = new int[][] {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueries sub = new SubrectangleQueries(rectangle);
        System.out.println(Arrays.deepToString(rectangle));

        System.out.println(sub.getValue(0, 2));
        sub.updateSubrectangle(0, 0, 3, 2, 5);
        System.out.println(Arrays.deepToString(rectangle));
        sub.updateSubrectangle(3, 0, 3, 2, 10);
        System.out.println(Arrays.deepToString(rectangle));
    }
}


class SubrectangleQueries {
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        while (row1 <= row2) {
            for (int i = col1; i <= col2; i++) {
                rectangle[row1][i] = newValue;
            }
            row1++;
        }
    }
    
    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}