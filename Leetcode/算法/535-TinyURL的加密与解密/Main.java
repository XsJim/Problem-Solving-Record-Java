import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Codec c = new Codec();
        System.out.println(c.decode(c.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}

class Codec {
    private static String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rand = new Random();

    private Map<String, String> map;
    
    public Codec() {
        map = new HashMap<>();
    }

    public String encode(String longUrl) {
        String key = null;
        do {
            key = getKey();
        } while (map.containsKey(key));
        map.put(key, longUrl);
        return "http://tinyurl.com/"+key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

    private static String getKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(s.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }
}