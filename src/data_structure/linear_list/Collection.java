package data_structure.linear_list;

public interface Collection<E> {

    /**
     * 获取collection中元素的数量
     *
     * @return collection中元素的数量
     */
    int size();

    /**
     * 判断collection是否为空
     *
     * @return 如果为空，返回true
     */
    boolean isEmpty();

    /**
     * 判断collection中是否包含指定的元素
     *
     * @param o 待核查的元素
     * @return 如果collection中包含指定的元素，返回true
     */
    boolean contains(Object o);

    /**
     * 确保collection中包含指定的元素
     *
     * @param e 确保要被添加进collection中的元素
     * @return 如果该方法执行后，collection发生了变化，返回true
     */
    boolean add(E e);

    /**
     * 从collection中移除一个指定的元素(移除首次出现位置上的元素)
     *
     * @param o 待移除的元素
     * @return 如果元素被成功移除，返回true
     */
    boolean remove(Object o);

    /**
     * 清空collection
     */
    void clear();

}
