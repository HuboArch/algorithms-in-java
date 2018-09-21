package data_structures.tree.binary_search_tree;

public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        E    e;
        Node left, right;

        Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int  size;

    public BinarySearchTree() {
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
     * 添加元素
     *
     * @param e 待添加元素
     */
    public void add(E e) {
        add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 判断是否包含某个元素
     *
     * @param e 待查找的元素
     * @return 存在返回 true
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 获取二分搜索树中的最小元素
     *
     * @return 最小元素
     */
    public E minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The binary search tree is empty.");
        }

        Node minNode = minimum(root);

        return minNode.e;
    }

    /**
     * 获取以node为根的二分搜索树中的最小元素所在的结点
     *
     * @param node 根节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 获取二分搜索树中的最大元素
     *
     * @return 最大元素
     */
    public E maximum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The binary search tree is empty.");
        }

        Node minNode = maximum(root);

        return minNode.e;
    }

    /**
     * 获取以node为根的二分搜索树的最小值所在的结点
     *
     * @param node 根节点
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 从二分搜索树中移除最小值所在的结点
     *
     * @return 最小值
     */
    public E removeMin() {
        root = removeMin(root);

        return minimum();
    }

    /**
     * 移除以node为根的二分搜索树的最小值所在的结点
     *
     * @param node 根节点
     * @return 移除最小结点后的根节点
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中移除最大值所在的结点
     *
     * @return 最大值
     */
    public E removeMax() {
        root = removeMax(root);

        return maximum();
    }

    /**
     * 移除以node为根的二分搜索树的最大值所在的结点
     *
     * @param node 根节点
     * @return 移除最大结点后的根节点
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

}
