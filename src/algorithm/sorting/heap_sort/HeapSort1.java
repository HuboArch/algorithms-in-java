package algorithm.sorting.heap_sort;

import data_structure.heap.MinHeap;

/**
 * @author Hubo
 * Project: algorithms-in-java
 * Time: 2019/1/10 9:35
 * Email: hubolinux@163.com
 */
public class HeapSort1 {

    public static void sort(Comparable[] arr) {

        int size = arr.length;
        MinHeap<Comparable> heap = new MinHeap<>();

        // 数组元素依次加入堆中
        // 这些元素进行了 n 次自顶向上的堆化操作，所以这个操作的时间复杂度为: O(nlogn)
        // 存在优化空间
        for (int i = 0; i < size; i++) {
            heap.add(i);
        }

        // 依次从堆顶取出元素放回数组
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = heap.poll();
        }

    }

}
