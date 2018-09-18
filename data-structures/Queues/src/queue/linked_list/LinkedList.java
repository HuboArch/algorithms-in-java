package queue.linked_list;

/**
 * 为实现基于链表的队列而准备的链表
 * 为实现队列出队和入队方法的时间复杂度为 O(1)
 * 此链表只能从链表尾部添加元素，从链表首部移除元素
 *
 * @param <E>
 */
public class LinkedList<E> {

    private class Node {
        E    e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addLast(E e) {
        Node node = new Node(e);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail = tail.next = node;
        }

        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not remove element from an empty list.");
        }

        Node tmpCell = head;

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }

        /* prevent loitering object */
        tmpCell.next = null;

        size--;

        return tmpCell.e;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not read the first element from an empty list.");
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("head ");

        Node cur = head;
        while (cur != null) {
            builder.append(cur.e);
            if (cur.next != null) {
                builder.append("->");
            }

            cur = cur.next;
        }

        builder.append(" tail");

        return builder.toString();
    }
}
