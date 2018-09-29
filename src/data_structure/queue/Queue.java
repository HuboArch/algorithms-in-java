package data_structure.queue;

import data_structure.linear_list.Collection;

public interface Queue<E> extends Collection<E> {

    /**
     * 向队列中插入指定的元素，在不违反容量限制的情况下插入成功，返回true
     * 没有可用空间时，抛出IllegalStateException异常
     *
     * @param e 待插入的元素
     */
    boolean add(E e);

    /**
     * 向队列中插入指定的元素，并不违反容量限制
     * 在有容量限制的队列中，此方法比add方法更可取，
     * 因为此方法仅仅通过抛出异常就可以让一次元素插入失败
     *
     * @param e 待插入的元素
     */
    boolean offer(E e);

    /**
     * 移除队列首元素
     * 该方法和poll的唯一不同是，当队列为空时会抛出异常，而poll返回null
     *
     * @return 队列首元素
     */
    E remove();

    /**
     * 移除队列首元素
     *
     * @return 队列首元素，若队列为空，返回null
     */
    E poll();

    /**
     * 获取队列首元素
     * 该方法和peek的唯一不同是，当队列为空时会抛出异常，而peek返回null
     *
     * @return 队列首元素
     */
    E element();

    /**
     * 获取队列首元素
     *
     * @return 队列首元素，若队列为空，返回null
     */
    E peek();

}
