public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 在完全二叉树的数组表示中，获取指定节点的父亲节点所在的索引
     *
     * @param idx 待查询的节点的在数组中的索引
     * @return 父亲节点在数组中的索引
     */
    private int parent(int idx) {
        if (idx < 0) {
            throw new IllegalArgumentException("Index 0 does not have parent node.");
        }

        return (idx - 1) / 2;
    }

    /**
     * 获取指定节点的左子节点在数组中的索引
     *
     * @param idx 待查询节点在数组中的索引
     * @return 左子节点的索引
     */
    private int leftChild(int idx) {
        return 2 * idx + 1;
    }

    /**
     * 获取指定节点的右子节点在数组中的索引
     *
     * @param idx 待查询节点在数组中的索引
     * @return 右子节点的索引
     */
    private int rightChild(int idx) {
        return 2 * idx + 2;
    }

}
