package binary_search_tree;

/**
 * NR -> Non-Recursive
 * @param <E>
 */
public class BinarySearchTreeNR<E extends Comparable<E>> {

    private class Node {
        E    e;
        Node left, right;

        Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int  size;

    public BinarySearchTreeNR() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {

    }
}
