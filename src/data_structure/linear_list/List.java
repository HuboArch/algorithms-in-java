package data_structure.linear_list;

public interface List<E> extends Collection<E> {

    /**
     * 获取指定索引位置上的元素
     *
     * @param index 索引
     * @return 指定索引位置上的元素
     */
    E get(int index);

    /**
     * 替换指定索引位置上的元素
     *
     * @param index   索引
     * @param element 待存储的元素
     * @return 该索引上之前存储的元素
     */
    E set(int index, E element);

    /**
     * 在指定的位置插入元素，该位置后面的元素(包括该位置上的元素)索引加一
     *
     * @param index   待插入的位置索引
     * @param element 待插入的元素
     */
    void add(int index, E element);

    /**
     * 移除指定索引上的元素，后面的元素索引减一
     *
     * @param index 待移除元素所在的索引
     * @return 被移除的元素
     */
    E remove(int index);

    /**
     * 获取指定元素第一次出现所在的索引
     *
     * @param o 待查询的元素
     * @return 返回元素第一次出现所在的索引，若不存在该元素，返回 -1
     */
    int indexOf(Object o);

    /* ========= Extended Methods from Collection ========= */
    /* =============== JUST FOR READABILITY =============== */

    /**
     * 获取list中元素的数量，如果list中的数量超过了Integer.MAX_VALUE,
     * 返回Integer.MAX_VALUE
     *
     * @return list中元素的数量
     */
    int size();

    /**
     * 判断list是否为空
     *
     * @return list为空, 返回true
     */
    boolean isEmpty();

    /**
     * 判断list中是否包含指定的元素
     *
     * @param o 待核查的元素
     * @return 若list中包含指定的元素，返回true
     */
    boolean contains(Object o);

    /**
     * 在list的尾部添加元素
     *
     * @param e 待添加的元素
     * @return 方法执行后，list发生了变化，返回true
     */
    boolean add(E e);

    /**
     * 移除list中首次出现的指定元素
     *
     * @param o 待移除的元素
     * @return 如果list中包含指定元素，返回true
     */
    boolean remove(Object o);

    /**
     * 清空list
     */
    void clear();
}
