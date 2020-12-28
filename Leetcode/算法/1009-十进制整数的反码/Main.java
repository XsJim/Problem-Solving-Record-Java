public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().bitwiseComplement(5));
        System.out.println(new Solution().bitwiseComplement(7));
        System.out.println(new Solution().bitwiseComplement(10));
    }
}

// 和对应长度的全1二进制数异或，就可取反
class Solution {
    public int bitwiseComplement(int N) {
        int Nc = N>>1;
        int m = 1;
        while (Nc != 0) {
            m <<= 1;
            m |= 1;
            Nc >>= 1;
        }

        return N^m;
    }
}