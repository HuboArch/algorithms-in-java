package data_structure.heap;

import data_structure.linear_list.ArrayList;

public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public int size() {
        return data.size();
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
            siftUp(i, e);
        }
        return true;
    }

    private void siftUp(int k, E x) {
        while (k > 0) {
            int parent = getParentIdx(k);
            E e = data.get(parent);
            if (x.compareTo(e) <= 0) {
                break;
            }
            data.set(k, e);
            k = parent;
        }
        data.set(k, x);
    }

    /**
     * 获取最大的元素
     *
     * @return 最大的元素
     */
    public E findMax() {
        if (data.size() == 0) {
            throw new IllegalArgumentException("Can not find the maximum element from an empty heap.");
        }

        return data.get(0);
    }

    /**
     * 取出堆中的最大元素
     *
     * @return 最大的元素
     */
    public E extractMax() {
        E ret = findMax();
        E e = data.remove(data.size() - 1);
        siftDown(0, e);
        return ret;
    }

    private void siftDown(int k, E x) {
        int size = size();
        int half = size >>> 1;
        while (k < half) {
            int child = getLeftChildIdx(k);
            E c = data.get(child);
            int right = child + 1;
            if (right < size && c.compareTo(data.get(right)) < 0) {
                c = data.get(child = right);
            }
            if (x.compareTo(c) >= 0) {
                break;
            }
            data.set(k, c);
            k = child;
        }
        data.set(k, x);
    }
}
