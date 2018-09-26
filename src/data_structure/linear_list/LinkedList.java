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

    /**
     * 移除指定的非空节点
     */
    private E unlink(Node<E> x) {
        // assert x != null
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;

        size--;

        return element;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    /**
     * 获取链表中元素的数量
     */
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void clear() {
        Node<E> x = first;
        while (x != null) {
            Node<E> next = x.next;

            x.item = null;
            x.prev = null;
            x.next = null;

            x = next;
        }

        first = last = null;
        size = 0;
    }

    /**
     * 判断是否是有效的元素索引
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * 判断是否是有效的位置索引
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 构造IndexOutOfBoundsException详细信息
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
