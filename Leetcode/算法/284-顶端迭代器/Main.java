import java.util.LinkedList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator it = new PeekingIterator(list.listIterator(0));
        System.out.println(it.next());
        System.out.println(it.peek());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}

class PeekingIterator implements Iterator<Integer> {
    private Integer tPeek;
    private Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
	    if (this.iterator.hasNext()) tPeek = this.iterator.next();
	}

	public Integer peek() {
        return tPeek;        
	}
	
	@Override
	public Integer next() {
        Integer re = tPeek;
        if (tPeek != null) {
            if (iterator.hasNext()) tPeek = iterator.next();
            else tPeek = null;
        }
        return re;
	}
	
	@Override
	public boolean hasNext() {
	    return iterator.hasNext() || tPeek != null;
	}
}