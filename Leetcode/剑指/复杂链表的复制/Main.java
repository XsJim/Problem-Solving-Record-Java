public class Main {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        Node current = head;
        while (current != null) {
            System.out.println(current + " " + current.val + " " + current.random);
            current = current.next;
        }
        current = new Solution().copyRandomList(head);
        System.out.println("------");
        while (current != null) {
            System.out.println(current + " " + current.val + " " + current.random);
            current = current.next;
        }
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node re = new Node(head.val);
        Node current = head.next;
        Node current_new = re;
        while (current != null) {
            current_new.next = new Node(current.val);
            current = current.next;
            current_new = current_new.next;
        }
        current = head;
        current_new = re;
        while (current_new != null) {
            if (current.random != null) {
                Node current_2 = head;
                Node current_3 = re;
                while (current_2 != current.random) {
                    current_2 = current_2.next;
                    current_3 = current_3.next;
                }
                current_new.random = current_3;
            }
            current = current.next;
            current_new = current_new.next;
        }
        return re;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}