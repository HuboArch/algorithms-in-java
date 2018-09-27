package data_structure.linear_list;

public class LinkedList<E> implements List<E> {
    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkedList() {
    }

    /*=============================================================*/
    /*===================== 实现List接口中的方法 =====================*/
    /*=============================================================*/

    /**
     * 获取指定索引上的元素
     *
     * @param index 待返回元素所在的索引
     * @return 指定索引上的元素
     */
    @Override
    public E get(int index) {
        checkElementIndex(index);

        return node(index).item;
    }

    /**
     * 替换指定索引上的元素
     *
     * @param index   待替换元素所在的索引
     * @param element 待存储的元素
     * @return 该索引上之前存储的元素
     */
    @Override
    public E set(int index, E element) {
        checkElementIndex(index);

        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;

        return oldVal;
    }

    /**
     * 在指定的位置插入元素，该位置后面的元素(包括该位置上的元素)索引加一
     *
     * @param index   待插入的位置索引
     * @param element 待插入的元素
     */
    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    /**
     * 移除指定索引上的元素，后面的元素索引减一
     *
     * @param index 待移除元素所在的索引
     * @return 被移除的元素
     */
    @Override
    public E remove(int index) {
        checkElementIndex(index);

        return unlink(node(index));
    }

    /**
     * 获取指定元素第一次出现所在的索引
     *
     * @param o 待查询的元素
     * @return 返回元素第一次出现所在的索引，若不存在该元素，返回 -1
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    /*=============================================================*/
    /*================== 实现Collection接口中的方法 ==================*/
    /*=============================================================*/

    /**
     * 获取链表中元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * 判断链表是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断链表中是否包含指定的元素
     *
     * @param o 待核查的元素
     * @return 若链表中包含指定的元素，返回true
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * 在链表的尾部添加元素
     *
     * @param e 待添加的元素
     * @return 方法执行后，链表发生了变化，返回true
     */
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * 移除链表中首次出现的指定元素
     *
     * @param o 待移除的元素
     * @return 如果链表中包含指定元素，返回true
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        Node<E> x = first;
        while (x != null) {
            Node<E> next = x.next;

            x.item = null;
            x.prev = null;
            x.next = null;

            x = next;
        }

        first = last = null;
        size = 0;
    }

    /*=============================================================*/
    /*========================== 私有方法 ==========================*/
    /*=============================================================*/

    /**
     * 在链表首部添加指定的元素
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);

        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }

        size++;
    }

    /**
     * 在链表尾部添加指定的元素
     */
    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);

        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        size++;
    }

    /**
     * 在指定的非空节点前插入指定元素
     */
    private void linkBefore(E e, Node<E> succ) {
        // assert succ != null

        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);

        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }

        size++;
    }

    /**
     * 移除非空首节点
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == this.first && f != null
        final E element = f.item;
        final Node<E> next = f.next;

        f.item = null;
        f.next = null; // let GC do its work

        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }

        size--;

        return element;
    }

    /**
     * 移除非空尾节点
     */
    private E unlinkLast(Node<E> l) {
        // assert l == this.last && l != null
        final E element = l.item;
        final Node<E> prev = l.prev;

        // let GC do its work
        l.item = null;
        l.prev = null;

        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }

        size--;

        return element;
    }

    /**
     * 移除指定的非空节点
     */
    private E unlink(Node<E> x) {
        // assert x != null
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;

        size--;

        return element;
    }

    /**
     * 判断是否是有效的元素索引
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * 判断是否是有效的位置索引
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 构造IndexOutOfBoundsException详细信息
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 获取指定索引上的节点
     */
    private Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.next;
            }
            return x;
        }
    }
}
