public class LinkedList<E> {

    /**
     * 以私有内部类的形式定义结点类型
     */
    private class Node {
        public E    e;
        public Node next;

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

}
