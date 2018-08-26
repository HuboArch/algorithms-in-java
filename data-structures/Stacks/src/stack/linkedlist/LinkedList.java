package stack.linkedlist;

public class LinkedList<E> {

    private class Node {
        E    e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyNode;
    private int  size;

    public LinkedList() {
        this.dummyNode = new Node();
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        dummyNode.next = new Node(e, dummyNode.next);
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed. The list is empty.");
        }

        Node head = dummyNode.next;
        dummyNode.next = head.next;
        head.next = null; // avoid loitering object

        return head.e;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not peek the first element from an empty list.");
        }

        return dummyNode.next.e;
    }

    public int getSize() {
        return size;
    }
}
