public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maximum69Number(9669));
        System.out.println(new Solution().maximum69Number(9996));
        System.out.println(new Solution().maximum69Number(9999));
    }
}

class Solution {
    public int maximum69Number (int num) {
        int cNum = num;
        int i = 0, j = 1;
        while (cNum != 0) {
            if (cNum % 10 == 6) i = j;
            cNum /= 10;
            j *= 10; 
        }
        return num + 3 * i;
    }
}