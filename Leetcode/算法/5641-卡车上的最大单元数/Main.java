import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumUnits(new int[][] {{1,3}, {2,2}, {3,1}}, 4));
        System.out.println(new Solution().maximumUnits(new int[][] {{5,10}, {2,5}, {4,7}, {3,9}}, 10));
    }
}

// 首先对箱子分类数组进行排序，按照单个箱子单元数降序排列
// 然后遍历箱子分类数组，尽可能的将其装入卡车，同时将装入的单元数量加入答案变量
// 最后返回这个总和
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        int sum = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] < truckSize) {
                sum += (boxTypes[i][0] * boxTypes[i][1]);
                truckSize -= boxTypes[i][0];
            } else {
                sum += (truckSize * boxTypes[i][1]);
                break;
            }
        }

        return sum;
    }
}