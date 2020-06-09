import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shortestToChar("loveleetcode", 'e')));
    }
}

class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] sArr = S.toCharArray();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == C) list.add(i);
        }
        int[] listArr = new int[list.size()+2];
        int j = 1;
        for (int i : list) {
            listArr[j++] = i;
        }
        listArr[0] = -1 * (listArr[1] + 2);
        listArr[listArr.length-1] = 2 * (sArr.length - 1) - listArr[listArr.length-2];
        int[] ans = new int[sArr.length]; j = listArr.length - 1;
        for (int i = 1, left, right, z, x; i < j; i++) {
            left = (listArr[i-1] + listArr[i]) / 2;
            right = (listArr[i] + listArr[i+1]) / 2;
            z = listArr[i] - 1; x = 1;
            while (z > left) ans[z--] = x++;
            z = listArr[i] + 1; x = 1;
            while (z <= right) ans[z++] = x++;
        }
        return ans;
    }
}