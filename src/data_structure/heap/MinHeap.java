package data_structure.heap;

import data_structure.linear_list.ArrayList;

import java.util.Comparator;

public class MinHeap<E extends Comparable<E>> {
    private ArrayList<E> data;
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

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 判断是否包含指定元素
     *
     * @param o 待查询元素
     * @return 包含指定的元素，返回true
     */
    public boolean contains(Object o) {
        return data.contains(o);
    }

    public E findMin() {
        return data.get(0);
    }

    /**
     * 向堆中添加元素
     *
     * @param e 待添加的元素
     */
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        data.add(e);

        // 为维持最小堆的特性，新添加的元素需要上浮
        int i = size() - 1;
        if (i != 0) {
            siftUp(i, e);
        }

        return true;
    }

    public void clear() {
        data.clear();
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

    /**
     * 在指定的位置插入元素，之后，为了维持堆的特性，需要上移
     * 插入的元素，直到元素大于或等于父节点中的值或者成为根节点
     *
     * @param k 待插入的位置
     * @param x 待插入的元素
     */
    private void siftUp(int k, E x) {
        if (comparator != null) {
            siftUpUsingComparator(k, x);
        } else {
            siftUpComparable(k, x);
        }
    }

    private void siftUpComparable(int k, E x) {
        while (k > 0) {
            int parent = parentIndex(k);
            E e = data.get(parent);

            if (x.compareTo(e) >= 0) {
                break;
            }

            data.set(k, e);
            k = parent;
        }
        data.set(k, x);
    }

    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = parentIndex(k);
            E e = data.get(parent);

            if (comparator.compare(x, e) >= 0) {
                break;
            }

            data.set(k, e);
            k = parent;
        }
        data.set(k, x);
    }

    /**
     * 在指定的位置插入元素，之后，为了维持堆的特性，需要下移
     * 插入的元素，直到元素小于或等于子节点中的最小值或是变为叶子节点
     *
     * @param k 待插入的位置
     * @param x 待插入的元素
     */
    private void siftDown(int k, E x) {
        if (comparator != null) {
            siftDownUsingComparator(k, x);
        } else {
            siftDownComparable(k, x);
        }
    }

    private void siftDownComparable(int k, E x) {
        int size = size();
        int half = size >>> 1;
        while (k < half) {                 // 循环至没有子节点，2*k + 1 < size ==> k < size/2 - 1/2 ==> k < size/2
            int child = leftChildIndex(k); // 假设左子节点中值最小
            E c = data.get(child);

            int right = child + 1;
            if (right < size && c.compareTo(data.get(right)) > 0) {
                c = data.get(child = right);
            }

            if (x.compareTo(c) <= 0) {
                break;
            }

            data.set(k, c);
            k = child;
        }
        data.set(k, x);
    }

    private void siftDownUsingComparator(int k, E x) {
        int size = size();
        int half = size >>> 1;
        while (k < half) {                 // 循环至没有子节点，2*k + 1 < size ==> k < size/2 - 1/2 ==> k < size/2
            int child = leftChildIndex(k); // 假设左子节点中值最小
            E c = data.get(child);

            int right = child + 1;
            if (right < size && comparator.compare(c, data.get(right)) > 0) {
                c = data.get(child = right);
            }

            if (comparator.compare(x, c) <= 0) {
                break;
            }

            data.set(k, c);
            k = child;
        }
        data.set(k, x);
    }

}
