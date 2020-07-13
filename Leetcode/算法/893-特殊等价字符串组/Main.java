public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numSpecialEquivGroups(new String[] {"abcd","cdab","cbad","xyzz","zzxy","zzyx"}));
        System.out.println(new Solution().numSpecialEquivGroups(new String[] {"abc","acb","bac","bca","cab","cba"}));
    }
}

class Solution {

    public int numSpecialEquivGroups(String[] A) {
        class Node {
            int[] a;
            int[] b;
            Node(String s) {
                a = new int[26];
                b = new int[26];
                char[] sArr = s.toCharArray();
                for (int i = 0; i < sArr.length; i += 2) {
                    a[sArr[i]-'a']++;
                }
                for (int i = 1; i < sArr.length; i += 2) {
                    b[sArr[i]-'a']++;
                }
            }

            boolean equal(Node n) {
                for (int i = 0; i < 26; i++) {
                    if (a[i] != n.a[i]) return false;
                    if (b[i] != n.b[i]) return false;
                }
                return true;
            }
        }

        Node[] ns = new Node[A.length];
        for (int i = 0; i < A.length; i++) ns[i] = new Node(A[i]);

        int ans = 0;
        boolean[] flag = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            if (!flag[i]) {
                for (int j = i + 1; j < A.length; j++) {
                    if (ns[i].equal(ns[j])) {
                        flag[j] = true;
                    }
                }
                ans++;
            }
        }

        return ans;
    }
}