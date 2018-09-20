package max_heap;

import max_heap.Array;

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
    private int getParentIdx(int idx) {
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
    private int getLeftChildIdx(int idx) {
        return 2 * idx + 1;
    }

    /**
     * 获取指定节点的右子节点在数组中的索引
     *
     * @param idx 待查询节点在数组中的索引
     * @return 右子节点的索引
     */
    private int getRightChildIdx(int idx) {
        return 2 * idx + 2;
    }

    /**
     * 向二叉堆中添加元素
     *
     * @param e 待添加的元素
     * @return 添加成功返回 true
     */
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Can not insert null into the heap.");
        }
        int i = size();
        if (i == 0) {
            data.set(0, e);
        } else {
            siftUp(i - 1, e);
        }
        return true;
    }

    private void siftUp(int k, E x) {
        while (k > 0) {
            int parent = getParentIdx(k);
            E   e      = data.get(parent);
            if (x.compareTo(e) <= 0) {
                break;
            }
            data.set(k, e);
            k = parent;
        }
        data.set(k, x);
    }
}
