package data_structures.linear_list;

public class LinkedList<E> {

    /**
     * 以私有内部类的形式定义结点类型
     */
    private class Node {
        public E    e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this(e, null);
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private Node tail;
    private int  size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.tail = null;
        this.size = 0;
    }

    /**
     * 查询链表中元素的个数
     *
     * @return 链表大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 为空返回 true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的指定索引位置添加元素
     *
     * @param idx 索引位置
     * @param e   待添加元素
     */
    public void add(int idx, E e) {
        if (idx < 0 || idx > size) {
            throw new IllegalArgumentException("Add failed. Illegal argument idx.");
        }

        if (idx == size) {
            if (idx == 0) {
                dummyHead.next = tail = new Node(e);
            } else {
                tail.next = new Node(e);
            }
        } else {
            Node prev = dummyHead;
            for (int i = 0; i < idx; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
        }

        size++;
    }

    /**
     * 在链表首部添加元素
     *
     * @param e 待添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表尾部添加元素
     *
     * @param e 待添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 从链表中删除指定索引位置的元素
     *
     * @param idx 索引位置
     * @return 被删除的元素
     */
    public E remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal argument idx.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < idx; i++) {
            prev = prev.next;
        }
        Node tmpCell = prev.next;
        prev.next = tmpCell.next;

        if (tmpCell.next == null) {
            tail = prev;
        }

        size--;

        return tmpCell.e;
    }

    /**
     * 从链表首部移除元素
     *
     * @return 被移除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表尾部移除元素
     *
     * @return 被移除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 获取指定索引位置的元素( 链表中其实并没有索引的概念，这里使用索引位置是为了方便理解 )
     *
     * @param idx 位置
     * @return 指定位置的元素
     */
    public E get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Get failed. Illegal argument idx.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取链表首元素
     *
     * @return 链表首元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表尾元素
     *
     * @return 链表尾元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 判断链表中是否含有指定的元素
     *
     * @param e 指定的元素
     * @return 含有返回 true
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            builder.append(cur.e).append("->");

            cur = cur.next;
        }
        builder.append("null");

        return builder.toString();
    }
}
