public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().threeConsecutiveOdds(new int[] {2,6,4,1}));
        System.out.println(new Solution().threeConsecutiveOdds(new int[] {1,2,34,3,4,5,7,23,12}));
    }
}

class Solution {
    // 连续三个数是否都为奇数
    // 从数组第二个数开始到数组倒数第二个数
    // 判断每个数左右两位是否为奇数
    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 1;
        while (i < arr.length - 1) {
            if ((arr[i] & 1) == 1 && (arr[i-1] & 1) == 1 && (arr[i+1] & 1) == 1) return true;
            i++;
        }
        return false;
    }
}