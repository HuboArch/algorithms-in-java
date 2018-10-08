package data_structure.queue;

import data_structure.heap.MinHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MinHeap<E> eMinHeap;

    public PriorityQueue() {
        eMinHeap = new MinHeap<>();
    }

    /**
     * 获取collection中元素的数量
     *
     * @return collection中元素的数量
     */
    @Override
    public int size() {
        return eMinHeap.size();
    }

    /**
     * 判断collection是否为空
     *
     * @return 如果为空，返回true
     */
    @Override
    public boolean isEmpty() {
        return eMinHeap.isEmpty();
    }

    /**
     * 判断队列中是否包含指定的元素
     *
     * @param o 待查询的元素
     * @return 如果队列中包含指定的元素，返回true
     */
    @Override
    public boolean contains(Object o) {
        return eMinHeap.contains(o);
    }

    /**
     * 向队列中插入指定的元素，在不违反容量限制的情况下插入成功，返回true
     * 没有可用空间时，抛出IllegalStateException异常
     *
     * @param e 待插入的元素
     */
    @Override
    public boolean add(E e) {
        return false;
    }

    /**
     * 从collection中移除一个指定的元素(移除首次出现位置上的元素)
     *
     * @param o 待移除的元素
     * @return 如果元素被成功移除，返回true
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /**
     * 清空collection
     */
    @Override
    public void clear() {

    }

    /**
     * 向队列中插入指定的元素，并不违反容量限制
     * 在有容量限制的队列中，此方法比add方法更可取，
     * 因为此方法仅仅通过抛出异常就可以让一次元素插入失败
     *
     * @param e 待插入的元素
     */
    @Override
    public boolean offer(E e) {
        return eMinHeap.offer(e);
    }

    /**
     * 移除队列首元素
     * 该方法和poll的唯一不同是，当队列为空时会抛出异常，而poll返回null
     *
     * @return 队列首元素
     */
    @Override
    public E remove() {
        return null;
    }

    /**
     * 移除队列首元素
     *
     * @return 队列首元素，若队列为空，返回null
     */
    @Override
    public E poll() {
        return null;
    }

    /**
     * 获取队列首元素
     * 该方法和peek的唯一不同是，当队列为空时会抛出异常，而peek返回null
     *
     * @return 队列首元素
     */
    @Override
    public E element() {
        return null;
    }

    /**
     * 获取队列首元素
     *
     * @return 队列首元素，若队列为空，返回null
     */
    @Override
    public E peek() {
        return null;
    }
}
