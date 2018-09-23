package data_structures.linear_list;

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
     * 在指定的索引位置插入元素
     *
     * @param idx 索引位置
     * @param e   待插入元素
     */
    public void add(int idx, E e) {
        if (idx < 0 || idx > size) {
            throw new IllegalArgumentException("Index is out of boundary.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size; i > idx; i--) {
            data[i] = data[i - 1];
        }

        data[idx] = e;

        size++;
    }


    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 移除指定索引位置的元素，并返回之
     *
     * @param idx 索引
     * @return E element
     */
    public E remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Index parameter is out of boundary.");
        }

        E tmpCell = data[idx];
        if (size - 1 - idx >= 0) {
            System.arraycopy(data, idx + 1, data, idx, size - 1 - idx);
        }
        data[size - 1] = null; // to be a loitering object

        size--;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return tmpCell;
    }

    /**
     * 移除首元素，并返回之
     *
     * @return E element
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移除尾元素，并返回之
     *
     * @return E element
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 数组扩容
     *
     * @param capacity 容量
     */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];

        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }

        data = newData;
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
