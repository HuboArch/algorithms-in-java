package data_structure.linear_list;

public class LinkedList<E> implements List<E> {
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

    /**
     * 在链表尾部添加节点
     */
    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 在指定的非空节点前插入指定元素
     */
    private void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    /**
     * 移除非空首节点
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == this.first && f != null
        final E element = f.item;
        final Node<E> next = f.next;

        f.item = null;
        f.next = null; // let GC do its work

        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }

        size--;

        return element;
    }

    /**
     * 移除非空尾节点
     */
    private E unlinkLast(Node<E> l) {
        // assert l == this.last && l != null
        final E element = l.item;
        final Node<E> prev = l.prev;

        // let GC do its work
        l.item = null;
        l.prev = null;

        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }

        size--;

        return element;
    }
}
