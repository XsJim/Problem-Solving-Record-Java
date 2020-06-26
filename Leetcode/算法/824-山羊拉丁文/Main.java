public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().toGoatLatin("I speak Goat Latin"));
        System.out.println(new Solution().toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}

class Solution {
    public String toGoatLatin(String S) {
        boolean[] map = new boolean[256];
        char[] flag = new char[] {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < flag.length; i++) {
            map[flag[i]] = true;
            map[flag[i]-'a'+'A'] = true;
        }

        String[] sArr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder sbb = new StringBuilder("ma");
        int i = 0;
        while (true) {
            if (map[sArr[i].charAt(0)]) {
                sb.append(sArr[i]);
            } else {
                char[] cArr = sArr[i].toCharArray();
                sb.append(cArr, 1, cArr.length-1);
                sb.append(cArr[0]);
            }
            sbb.append('a');
            sb.append(sbb.toString());
            if (++i < sArr.length) sb.append(' ');
            else break;
        }

        return sb.toString();
    }
}