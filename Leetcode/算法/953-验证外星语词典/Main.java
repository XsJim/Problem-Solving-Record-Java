public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(new Solution().isAlienSorted(new String[] {"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(new Solution().isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(new Solution().isAlienSorted(new String[] {"ubg","kwh"}, "qcipyamwvdjtesbghlorufnkzx"));
        System.out.println(new Solution().isAlienSorted(new String[] {"zirqhpfscx","zrmvtxgelh","vokopzrtc","nugfyso","rzdmvyf","vhvqzkfqis","dvbkppw","ttfwryy","dodpbbkp","akycwwcdog"}, "khjzlicrmunogwbpqdetasyfvx"));
    }
}

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        char[] orderArr = order.toCharArray();
        for (int i = 0; i < orderArr.length; i++) {
            map[orderArr[i]-'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!talgo(words[i-1], words[i], map)) return false;
        }

        return true;
    }

    private static boolean talgo(String l, String r, int[] map) {
        char[] lArr = l.toCharArray();
        char[] rArr = r.toCharArray();

        int i = 0;
        int min = Math.min(lArr.length, rArr.length);
        while (i < min) {
            int ll = lArr[i]-'a', rr = rArr[i]-'a';
            if (map[ll] > map[rr]) return false;
            if (map[ll] < map[rr]) return true;
            i++;
        }
        if (lArr.length < rArr.length) return true;
        return false;
    }
}