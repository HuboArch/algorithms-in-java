package data_structures.linear_list;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private Object[] elementData;
    private int size;

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断是否包含指定的元素
     *
     * @param o 待检测的元素
     * @return 包含指定的元素，返回true
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * 获取指定元素在list中首次出现的索引
     *
     * @param o 待查询的元素
     * @return 元素首次出现的索引，若list中不包含指定元素，返回-1
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 获取指定索引位置上的元素
     *
     * @param index 索引
     * @return 指定索引位置上的元素
     */
    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }

    /**
     * 使用指定元素替换指定索引位置上的元素
     *
     * @param index   待替换元素所在的索引位置
     * @param element 待存储的元素
     * @return 索引位置上之前所存储的元素
     */
    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * 在list的尾部添加元素
     *
     * @param e 待添加的元素
     * @return 方法执行后，list发生变化，返回true
     */
    public boolean add(E e) {
        if (size == elementData.length) {
            resize(2 * elementData.length);
        }

        elementData[size++] = e;
        return true;
    }

    /**
     * 在指定的索引位置插入元素，后面的元素向右移动一个索引位置
     *
     * @param index   待插入的索引位置
     * @param element 待插入的元素
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (size == elementData.length) {
            resize(2 * elementData.length);
        }

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = element;
        size++;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 移除指定索引位置上的元素，后面的元素向左移动一个索引位置
     *
     * @param index 带移除元素所在的索引位置
     * @return 被移除的元素
     */
    public E remove(int index) {
        rangeCheck(index);

        E oldValue = elementData(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null; // Let GC do its work!
        return oldValue;
    }

    /**
     * 调整静态数组空间大小
     *
     * @param newCapacity 待调整的容量
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("max_heap.data_structures.linear_list.ArrayList: size = %d, capacity = %d\n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }
}
