package binary_search_tree;

public class BinarySearchTree_Normal<E extends Comparable<E>> {

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

    public BinarySearchTree_Normal() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
