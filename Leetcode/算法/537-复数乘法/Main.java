public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(new Solution().complexNumberMultiply("1+-1i", "1+-1i"));
    }
}

// 解析字符串，进行运算，然后拼接
class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] A = a.split("\\+|i");
        String[] B = b.split("\\+|i");

        int ar = Integer.parseInt(A[0]);
        int ai = Integer.parseInt(A[1]);
        int br = Integer.parseInt(B[0]);
        int bi = Integer.parseInt(B[1]);
        
        return (ar * br - ai * bi) + "+" + (ar * bi + ai * br) + "i";
    }
}