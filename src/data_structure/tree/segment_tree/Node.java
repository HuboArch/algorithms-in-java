package data_structure.tree.segment_tree;

/**
 * Created by lyn
 */
class Node<T> {
    int l;
    int r;
    T value;

    Node(int l, int r, T value) {
        this.l = l;
        this.r = r;
        this.value = value;
    }

    Node(int l, T value) {
        this(l, l, value);
    }
}
