package binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * NR -> Non-Recursive
 *
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
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node cur = nodeStack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                nodeStack.push(cur.right);
            }
            if (cur.left != null) {
                nodeStack.push(cur.left);
            }
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            Node cur = nodeQueue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                nodeQueue.add(cur.left);
            }
            if (cur.right != null) {
                nodeQueue.add(cur.right);
            }
        }
    }
}
