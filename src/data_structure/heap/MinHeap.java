package data_structure.heap;

import data_structure.linear_list.ArrayList;

import java.util.Comparator;

public class MinHeap<E extends Comparable<E>> {
    private ArrayList<E> data;
    private int size = 0;
    private final Comparator<? super E> comparator;

    public MinHeap() {
        this(null);
    }

    public MinHeap(int initialCapacity) {
        this(initialCapacity, null);
    }

    public MinHeap(Comparator<? super E> comparator) {
        this.data = new ArrayList<>();
        this.comparator = comparator;
    }

    public MinHeap(int initialCapacity, Comparator<? super E> comparator) {
        this.data = new ArrayList<>(initialCapacity);
        this.comparator = comparator;
    }

    public int size() {
        return data.size();
    }

    /*=============================================================*/
    /*========================== 私有方法 ==========================*/
    /*=============================================================*/

    /**
     * 在完全二叉树的数组表示中，获取指定节点的父亲节点所在的索引
     *
     * @param index 待查询的节点的在数组中的索引
     * @return 父亲节点在数组中的索引
     */
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * 获取指定节点的左子节点在数组中的索引
     *
     * @param index 待查询节点在数组中的索引
     * @return 左子节点的索引
     */
    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }
}
