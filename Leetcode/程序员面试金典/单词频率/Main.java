import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        WordsFrequency wordsFrequency = new WordsFrequency(new String[] {"i", "have", "an", "apple", "he", "have", "a", "pen"});
        System.out.println(wordsFrequency.get("you"));
        System.out.println(wordsFrequency.get("have"));
        System.out.println(wordsFrequency.get("an"));
        System.out.println(wordsFrequency.get("apple"));
        System.out.println(wordsFrequency.get("pen"));
    }
}

class WordsFrequency {
    private HashMap<String, int[]> map;
    public WordsFrequency(String[] book) {
        map = new HashMap<String, int[]>();
        for (int i = 0; i < book.length; i++) {
            int[] x = map.get(book[i]);
            if (x != null) x[0]++;
            else map.put(book[i], new int[] {1});
        }
    }
    
    public int get(String word) {
        int[] x = map.get(word);
        return x != null ? x[0] : 0;
    }
}