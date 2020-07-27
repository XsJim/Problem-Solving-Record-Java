public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canWinNim(4));
    }
}

class Solution {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}