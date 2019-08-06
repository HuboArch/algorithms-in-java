package data_structure.heap;

import java.util.Comparator;

/**
 * @author Hubo
 * Project: algorithms-in-java
 * Time: 2019/1/9 14:47
 * Email: hubolinux@163.com
 */
public class MinHeap<E> {

  private Object[] elements;

  private int size;

  private final Comparator<? super E> comparator;

  private static final int DEFAULT_INITIAL_CAPACITY = 11;

  public MinHeap(int initialCapacity, Comparator<? super E> comparator) {
    this.elements   = new Object[initialCapacity];
    this.comparator = comparator;
  }

  public MinHeap(int initialCapacity) {
    this(initialCapacity, null);
  }

  public MinHeap(Comparator<? super E> comparator) {
    this(DEFAULT_INITIAL_CAPACITY, comparator);
  }

  public MinHeap() {
    this(DEFAULT_INITIAL_CAPACITY, null);
  }

  // heapify
  @SuppressWarnings("unchecked")
  public MinHeap(E[] arr) {
    int len = arr.length;

    this.elements   = new Object[len];
    this.size       = len;
    this.comparator = null;

    System.arraycopy(arr, 0, this.elements, 0, len);

    // 从最后一个非叶子节点开始，向前依次对数组中的元素进行自顶向下的堆化操作
    // 时间复杂度: O(n)
    int nonLeaf = (size - 1) / 2;
    for (int i = nonLeaf; i >= 0; i--) {
      E element = (E) elements[i];
      siftDown(i, element);
    }
  }

  private void grow() {
    final Object[] newElementData = new Object[elements.length * 2];
    System.arraycopy(elements, 0, newElementData, 0, elements.length);
    elements = newElementData;
  }

  @SuppressWarnings("unchecked")
  private int compare(E a, E b) {
    if (comparator != null) {
      return comparator.compare(a, b);
    } else {
      return ((Comparable<? super E>) a).compareTo(b);
    }
  }

  /**
   * 向堆中添加元素
   *
   * @param element 待添加元素
   */
  public void add(E element) {
    // assert element is not null
    if (elements.length == size) { // 存储小顶堆数据项的数组已满
      grow();
    }

    elements[++size] = element;

    // 自底向上进行堆化操作
    int index = size - 1;
    if (index != 0) {
      siftUp(index, element);
    }
  }

  /**
   * 自底向上的堆化操作
   *
   * @param k       上浮元素在数组中的索引，通常是 this.size - 1
   * @param element 待上浮的元素
   */
  @SuppressWarnings("unchecked")
  private void siftUp(int k, E element) {

/*
        while (k > 0) {
            int parent = parentIndex(k);
            e   p      = (e) elements[parent];

            if (compare(element, p) >= 0) {
                break;
            }
            elements[k] = parentl

            k = parent;
        }
*/

    for (int parent = parentIndex(k);
         k > 0;
         k = parent) {

      E p = (E) elements[parent];

      if (compare(element, p) < 0) {
        elements[k] = p;
      } else {
        break;
      }

    }

    elements[k] = element;
  }

  /**
   * 取出堆顶元素
   *
   * @return 堆顶元素
   */
  @SuppressWarnings("unchecked")
  public E poll() {
    if (size == 0) {
      return null;
    }
    final E min = (E) elements[0];

    elements[0]        = elements[--size];
    elements[size + 1] = null;  // let GC do its work

    // 自顶向下进行堆化操作
    E element = (E) elements[0];
    siftDown(0, element);

    return min;
  }

  /**
   * 自顶向下的堆化操作
   *
   * @param k       待下沉堆顶元素的数组索引，为 0
   * @param element 待下沉的堆顶元素
   */
  @SuppressWarnings("unchecked")
  private void siftDown(int k, E element) {

    int half = size / 2;
    while (k < half) {
            /*int child = leftChildIndex(k);
            E minChild = (E) elements[child];

            int right = child + 1;
            if (right < size && compare(minChild, (E) elements[right]) > 0) {
                minChild = (E) elements[child = right];
            }

            if (compare(element, minChild) <= 0) {
                break;
            }
            elements[k] = minChild;

            k = child;*/

      int left  = leftChildIndex(k);
      int right = left + 1;

      if (right < size) {
        E minChild = compare((E) elements[right], (E) elements[left]) < 0
                ? (E) elements[right]
                : (E) elements[left];
      }


    }

    elements[k] = element;
  }

  private int parentIndex(int index) {
    return (index - 1) / 2;
  }

  private int leftChildIndex(int index) {
    return 2 * index + 1;
  }


}
