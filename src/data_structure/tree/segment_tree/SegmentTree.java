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

    /**
     * 获取指定索引处的元素
     */
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    private void rangeCheck(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }
}
