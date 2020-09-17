public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("LEETCODEISHIRING", 3));
        System.out.println(new Solution().convert("LEETCODEISHIRING", 4));
    }
}

class Solution {
    // 首先计算出放置字符的容器的长度
    // 创建二维字符数组
    // 然后模拟题目规则将字符放入数组
    // 再将数组内容按序转为字符串并返回
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = 0;
		int sLen = s.length();
		boolean flag = true;
		int count = 0;
		while (sLen > 0) {
			if (flag) {
				sLen -= numRows;
				flag = false;
			} else {
				sLen--;
				count++;
				if (count == numRows - 2) {
					flag = true;
					count = 0;
				}
			}
			len++;
		}
		
		char[][] c = new char[numRows][len];
		int jump = numRows - 1;
        int z = 0;
        int x = 0, y = 0;
        while (z < s.length()) {
            while (z < s.length() && x < numRows) {
                c[x][y] = s.charAt(z);
                x++;
                z++;
            }
            x = 0;
            z += numRows - 2;
            y += jump;
        }
        if (numRows > 2) {
            z = numRows;
            x = numRows - 2;
            y = 1;
            while (y < len) {
                c[x][y] = s.charAt(z);
                x--; z++; y++;
                if (x == 0) {
                    x = numRows - 2;
                    z += numRows;
                    y++;
                }
            }
        }

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				if (c[i][j] != (char)0) sb.append(c[i][j]);
			}
		}
		
		return sb.toString();
    }
}