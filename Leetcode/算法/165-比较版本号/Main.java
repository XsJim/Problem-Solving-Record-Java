import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("0.1","1.1"));
        System.out.println(new Solution().compareVersion("1.0.1","1"));
        System.out.println(new Solution().compareVersion("7.5.2.4","7.5.3"));
        System.out.println(new Solution().compareVersion("1.01","1.001"));
        System.out.println(new Solution().compareVersion("1.0","1.0.0"));
        System.out.println(new Solution().compareVersion("1","1.1"));
    }
}

class Solution {
    // 首先将给定的字符串进行拆分，得到两个数字序列
    // 为了方便比较，将两序列中较短的一个末尾补 0 ，使两个序列长度相同
    // 然后逐位比较大小，返回相应的数字即可
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = getIntList(version1);
        List<Integer> v2 = getIntList(version2);
        dq(v1, v2);
        Iterator<Integer> it1 = v1.iterator();
        Iterator<Integer> it2 = v2.iterator();
        while (it1.hasNext()) {
            int x = Integer.compare(it1.next(), it2.next());
            if (x != 0) return x;
        }

        return 0;
    }

    private static List<Integer> getIntList(String s) {
        List<Integer> v = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int x = 0;
            while (i < s.length() && s.charAt(i) == '0') i++;
            while (i < s.length() && s.charAt(i) != '.') {
                x *= 10;
                x += (s.charAt(i) - '0');
                i++;
            }
            v.add(x);
            i++;
        }
        return v;
    }

    private static void dq(List<Integer> v1, List<Integer> v2) {
        if (v1.size() == v2.size()) return;
        List<Integer> tmin = v1.size() > v2.size() ? v2 : v1;
        int tmax = v1.size() > v2.size() ? v1.size() : v2.size();
        while (tmin.size() < tmax) tmin.add(0);
    }
}