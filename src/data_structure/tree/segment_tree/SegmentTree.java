package data_structure.tree.segment_tree;

public class SegmentTree<E> {
    private E[] tree;
    private E[] data;

    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
    }

    /**
     * 获取线段树的大小
     */
    public int size() {
        return data.length;
    }

}
