public class Main {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        int param_1 = obj.get(1);
        obj.put(3, 3);
        int param_2 = obj.get(2);
        obj.put(4, 4);
        int param_3 = obj.get(1);
        int param_4 = obj.get(3);
        int param_5 = obj.get(4);
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
    }
}

class LRUCache {
    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        void setPrev(Node prev) {
            this.prev = prev;
        }

        void setNext(Node next) {
            this.next = next;
        }

        void changeValue(int value) {
            this.value = value;
        }

        int getKey() {
            return key;
        }

        int getValue() {
            return value;
        }

        Node getPrev() {
            return prev;
        }

        Node getNext() {
            return next;
        }
    }

    class List {
        Node[] map;
        Node head;
        Node tail;

        List() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.setNext(tail);
            tail.setPrev(head);

            map = new Node[3005];
        }

        void addLast(Node n) {
            Node prevLast = tail.getPrev();

            prevLast.setNext(n);

            n.setPrev(prevLast);
            n.setNext(tail);

            tail.setPrev(n);

            map[n.getKey()] = n;
        }

        void removeFirst() {
            Node first = head.getNext();
            if (first != tail) remove(first);
        }

        void remove(Node n) {
            Node prev = n.getPrev();
            Node next = n.getNext();

            prev.setNext(next);
            next.setPrev(prev);

            map[n.getKey()] = null;
        }

        Node get(int key) {
            return map[key];
        }
    }

    int capacity;
    List list;
    int length;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        length = 0;
        list = new List();
    }

    public int get(int key) {
        Node n = list.get(key);

        if (n != null) {
            list.remove(n);
            list.addLast(n);
        } else return -1;

        return n.getValue();
    }
    
    public void put(int key, int value) {
        Node n = list.get(key);
        if (n != null) {
            list.remove(n);
            n.changeValue(value);
            list.addLast(n);
        } else {
            if (length == capacity) {
                list.removeFirst();
            } else length++;
            list.addLast(new Node(key, value));
        }
    }
}
