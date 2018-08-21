public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在指定的索引位置插入元素
     *
     * @param idx 索引位置
     * @param e   待插入元素
     */
    public void insert(int idx, E e) {
        if (idx < 0 || idx > size) {
            throw new IllegalArgumentException("Index is out of boundary.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size; i > idx; i++) {
            data[i] = data[i - 1];
        }

        data[idx] = e;

        size++;
    }


    public void append(E e) {
        insert(size, e);
    }

    public void prepend(E e) {
        insert(0, e);
    }

    /**
     * 获取指定索引位置的元素
     *
     * @param idx 索引位置
     * @return E
     */
    public E get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Index is out of boundary.");
        }

        return data[idx];
    }

    public void set(int idx, E e) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Index is out of boundary.");
        }

        data[idx] = e;
    }

    /**
     * 判断数组是否某个元素
     *
     * @param e 待查找的元素
     * @return boolean
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查找元素e所在的索引
     *
     * @param e 元素
     * @return int
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
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

        builder.append("Array: size = %d, capacity = %d\n", size, data.length);
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
