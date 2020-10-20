import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reformatDate("20th Oct 2052"));
        System.out.println(new Solution().reformatDate("6th Jun 1933"));
        System.out.println(new Solution().reformatDate("26th May 1960"));
    }
}

// 截取字符串并转换即可
class Solution {
    public String reformatDate(String date) {
        String[] month = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= month.length; i++) {
            if (i > 9) map.put(month[i-1], ""+i);
            else map.put(month[i-1], "0"+i);
        }

        StringBuilder sb = new StringBuilder();
        int x = date.length() - 4;
        for (int i = 0; i < 4; i++) {
            sb.append(date.charAt(x++));
        }
        sb.append('-');
        x = date.length() - 8;
        sb.append(map.get(date.substring(x, x+3)));
        sb.append('-');

        int day = 0;
        x = 0;
        while (true) {
            char c = date.charAt(x);
            if (c >= '0' && c <= '9') {
                day *= 10;
                day += (c - '0');
            } else break;
            x++;
        }
        if (day < 10) sb.append("0"+day);
        else sb.append(day);

        return sb.toString();
    }
}