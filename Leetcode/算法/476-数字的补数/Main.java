public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(5));
        System.out.println(new Solution().findComplement(1));
    }
}

class Solution {
    public int findComplement(int num) {
        int cNum = 1;
        for (int i = 0; i < 30; i++) cNum <<= 1;
        while ((cNum & num) == 0) cNum >>= 1;
        int ans = 0;
        while (cNum > 0) {
            if ((cNum & num) == 0) ans |= cNum;
            cNum >>= 1;
        }
        return ans;
    }
}