package data_structure.linear_list;

public class LinkedList<E> {
    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkedList() {
    }

    /**
     * 在链表首部添加节点
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }
}
