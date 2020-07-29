public class Main {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");
        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));
        bh.visit("linkedin.com");
        System.out.println(bh.forward(2));
        System.out.println(bh.back(2));
        System.out.println(bh.back(7));
    }
}

class BrowserHistory {
    private static final int size = 6000;
    private String[] urls;
    private int top;
    private int current;

    public BrowserHistory(String homepage) {
        urls = new String[size];
        top = -1;
        urls[++top] = homepage;
        current = top;
    }
    
    public void visit(String url) {
        urls[++current] = url;
        top = current;
    }
    
    public String back(int steps) {
        current -= steps;
        if (current < 0) current = 0;
        return urls[current];
    }
    
    public String forward(int steps) {
        current += steps;
        if (current > top) current = top;
        return urls[current];
    }
}