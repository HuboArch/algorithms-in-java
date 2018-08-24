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
}
