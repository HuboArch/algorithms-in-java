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

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
