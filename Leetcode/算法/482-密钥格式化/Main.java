public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new Solution().licenseKeyFormatting("2-5g-3-J", 2));
    }
}

class Solution {
    // 首先查询字符串中非 '-' 字符的数量
    // 如果这个数量为 0 ，那么不论要求每份分配多少个字符，都只能返回一个空串
    // 否则，不论要求每份分配多少个字符，第一份都能被分配（第一份不要求等于 K ）
    // 第一份分配的字符数的具体数量是：sum % K
    // 也就是在其他块被完整分配的情况下，剩下的不足 K 个的字符
    // 当第一块被分配完毕后，需要判断是否还有字符需要分配，也就是 sum 是否比 K 大
    // 如果 sum < K 说明在第一块分配完毕后，整个密钥也已经完成，直接返回第一块即可
    // 否则，添加一个分隔符 '-' ，然后继续分配之后的字符
    // 当长度达到要求且后续还有字符需要放置时，为密钥添加 '-'
    public String licenseKeyFormatting(String S, int K) {
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-') sum++;
        }
        if (sum == 0) return "";
        char[] ans = new char[sum+(int)Math.ceil(sum*1.0/K)-1];

        int j = 0;
        int z = 0;

        while (z < (sum % K)) {
            char c = S.charAt(j);
            if (c != '-') {
                ans[z] = getChar(c);
                z++;
            }
            j++;
        }
        if (sum < K) return new String(ans, 0, z);

        if (sum % K != 0) {
            ans[z++] = '-';
        }
        int count = 0;
        while (z < ans.length) {
            char c = S.charAt(j);
            if (c != '-') {
                if (count == K) {
                    ans[z] = '-';
                    count = 0;
                } else {
                    ans[z] = getChar(c);
                    j++;
                    count++;
                }
                z++;
            } else j++;
        }

        return new String(ans);
    }

    private static char getChar(char c) {
        if (c >= 'a' && c <= 'z') return (char)(c-'a'+'A');
        return c;
    }
}