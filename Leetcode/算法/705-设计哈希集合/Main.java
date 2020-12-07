public class Main {
    public static void main(String[] args) {
        MyHashSet mhs = new MyHashSet();
        mhs.add(1);
        mhs.add(2);
        System.out.println(mhs.contains(1));
        System.out.println(mhs.contains(3));
        mhs.add(2);
        System.out.println(mhs.contains(2));
        mhs.remove(2);
        System.out.println(mhs.contains(2));
    }
}

// 适当使用数组，通过32位整数的低30位来标记映射数字存在与否
// 也就是说，建立一个适当大小的数组，数组下标表示的是一个区间标记，预定一个数字只使用低30位，所以一个区间内也就可以标记30个数字
// 依次规则，给定数字key，它所对应的区间下标就是key/30，它在区间内对应的位就是key%30
// 这样，通过将位标记为1或者0，来表示数字的存在或者不存在
class MyHashSet {
    private int[] map;
    private static final int R = 30;
    public MyHashSet() {
        map = new int[35000];
    }
    
    public void add(int key) {
        int h = key / R;
        int y = key % R;
        map[h] |= (1 << y);
    }
    
    public void remove(int key) {
        int h = key / R;
        int y = key % R;
        map[h] &= (0x3fffffff ^ (1 << y));
    }
    
    public boolean contains(int key) {
        int h = key / R;
        int y = key % R;
        return (map[h] & (1 << y)) != 0;
    }
}